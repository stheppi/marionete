package com.marionette.training.chapter08

object CaseClass4 extends App {

  //1
  case class Address(street: String, city: String, country: String)

  case class Person(name: String, age: Int, address: Address)

  val alice = Person("Alice", 25, Address("1 Scala Lane", "Chicago", "USA"))
  val bob = Person("Bob", 29, Address("2 Java Ave.", "Miami", "USA"))
  val charlie = Person("Charlie", 32, Address("3 Python Ct.", "Boston", "USA"))

  for (person <- Seq(alice, bob, charlie)) {
    person match {
      case Person("Alice", 25, Address(_, "Chicago", _)) =>
        println("Hi Alice!")
      case Person("Bob", 29, Address("2 Java Ave.", "Miami", "USA")) =>
        println("Hi Bob!")
      case Person(name, age, _) =>
        println(s"Who are you, $age year-old person named $name?")
    }
  }


  //2
  val itemsCosts = Seq(("Pencil", 0.52), ("Paper", 1.35), ("Notebook", 2.43))
  val itemsCostsIndices = itemsCosts.zipWithIndex
  for (itemCostIndex <- itemsCostsIndices) {
    itemCostIndex match {
      case ((item, cost), index) => println(s"$index: $item costs $cost each")
    }
  }

  /*
  object Person {
    def apply(name: String, age: Int, address: Address) = new Person(name, age, address)

    def unapply(p: Person): Option[Tuple3[String,Int,Address]] = Some((p.name, p.age, p.address))
    ...
  }
   */


  /*
  SCALA 2.11.1
  To gain some performance benefits, Scala 2.11.1 relaxed the requirement that unapply return an Option[T].
  It can now return any type as long as it has the following methods:

  def isEmpty: Boolean
  def get: T
   */
}
