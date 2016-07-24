package com.marionette.training.chapter01

object PartiallyApplied extends App {
  def factorOf(x: Int, y: Int): Boolean = y % x == 0

  def multipleOf3: (Int) => Boolean = factorOf(3, _: Int)


  println(multipleOf3(11))
  println(multipleOf3(12))


  def isEven = factorOf(2, _: Int)

  println(isEven(29))
}


object Curring extends App {
  def factorOf(x: Int)(y: Int): Boolean = y % x == 0

  def multipleOf3: (Int) => Boolean = factorOf(3) _


  println(multipleOf3(11))
  println(multipleOf3(12))


  def isEven = factorOf(2) _

  println(isEven(29))
  println(isEven(30))
}
