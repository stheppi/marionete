package com.marionette.training.chapter06

object CtorSuper extends App {

  case class Person(name: String,
                    age: Option[Int] = None)

  class Employee(name: String,
                 age: Option[Int] = None,
                 val title: String = "[unknown]",
                 val manager: Option[Employee] = None) extends Person(name, age) {

    override def toString =
      s"Employee($name, $age, $title, $manager)"
  }

  val ceo = new Employee("Joe CEO", title = "CEO")
  println(ceo)

  val chuck = new Employee("Chuck", Some(20), "Zombie Dev", Some(ceo))
  println(chuck)
}
