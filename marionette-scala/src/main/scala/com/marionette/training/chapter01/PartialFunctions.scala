package com.marionette.training.chapter01

object PartialFunctions1 extends App {

  //println(List(41, "cat").map { case i: Int ⇒ i + 1 })
}

object PartialFunctions2 extends App {

  val fraction = new PartialFunction[Int, Int] {
    def apply(d: Int) = 42 / d

    def isDefinedAt(d: Int) = d != 0
  }

  println(fraction.isDefinedAt(0))
  println(fraction.isDefinedAt(42))

  // what is the output
  //fraction(0)

  val fraction1: PartialFunction[Int, Int] = {
    case i: Int if i != 0 => 42 / i
  }

  //println(fraction1(0))
  println(fraction1(42))

  //scala -Xprint:typer -e 'Some(1).collect { case 1 => "Hello"; case 2 => "Goodbye"}'

  val lessThanTen: Seq[Int] => Seq[Int] = _.collect { case i if i < 10 => i }
  println(lessThanTen(Seq(193, 44, 1, 30, 6)))

}

object PartialFunctions3 extends App {


  val liar: PartialFunction[Any, Int] = {
    case i: Int => i;
    case s: String => s.toInt
  }

  println(Seq(1, "Lisbon").map(liar))

  val honest = PartialFunction[Any, Int] {
    case i: Int => i
    //???
  }

  //println(Seq(1, "Lisbon").map(liar))
}

object PartialFunctions extends App {
  val pets = Seq("dog", "cat", "horse")
  println(pets(0))

  println(Seq(1, 2) collect pets)

  println(pets.lift(11))
}
