package com.marionette.training.chapter08

import com.marionette.training.chapter08.CaseClass4.{Address, Person}

object ValuesExtracted7 extends App {
  val Person(name, age, Address(_, state, _)) = Person("Dean", 29, Address("1 Scala Way", "CA", "USA"))
  println(s"name=$name")
  println(s"age=$age")
  println(s"state=$state")

  val (d, t) = doubleAndTriple(3)
  println(s"x2=$d")
  println(s"x3=$t")

  //Avoid the annoying _._1._2 use pattern matching

  def doubleAndTriple(x: Int) = (x * 2, x * 3)
}
