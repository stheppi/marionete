package com.marionette.training.chapter08


object ValueVariableTypes1 extends App {
  for {
    x <- Seq(1, 2, 2.7, "one", "two", 'four)
  } {
    val str = x match {
      case 1 => "int 1"
      case i: Int => "other int: " + i
      case d: Double => "a double: " + x
      case "one" => "string one"
      case s: String => "other string: " + s
      case unexpected => "unexpected value: " + unexpected + "=" + unexpected.getClass.getCanonicalName
    }
    println(str)
  }

  for {
    x <- Seq(1, 2, 2.7, "one", "two", 'four)
  } {
    val str = x match {
      case _: Int | _: Double => "number : " + x
      case "one" => "string one"
      case s: String => "other string: " + s
      case unexpected => "unexpected value: " + unexpected + "=" + unexpected.getClass.getCanonicalName
    }
    println(str)
  }


  for (i <- Seq(1,2,3,4)) {
    i match {
      case _ if i%2 == 0 => println(s"even: $i")
      case _             => println(s"odd:  $i")
    }
  }

  checkY(100)

  def checkY(y: Int) = {
    for {
      x <- Seq(99, 100, 101)
    } {
      val str = x match {
        case y => "found y!" //!
        case i: Int => "int: " + i
      }
      println(str)
    }
  }


  /*
  In case clauses, a term that begins with a lowercase letter is assumed to be the name of a new variable that will hold value.
  To refer to a previously defined variable, enclose it in back ticks.
  A term that begins with an uppercase letter is assumed to be a type name!
   */
}
