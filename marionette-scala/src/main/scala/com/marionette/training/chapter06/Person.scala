package com.marionette.training.chapter06


class Person(var name: String, var age: Int)

case class ImmutablePerson(name: String, age: Int)

object PersonApp extends App{
  val p1 = new Person("Alex", 29)
  p1.age=30
  println(p1)

  Tuple2
}