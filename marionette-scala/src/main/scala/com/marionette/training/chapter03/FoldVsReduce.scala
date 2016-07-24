package com.marionette.training.chapter03

object FoldVsReduce extends App {
  val n = Vector(1, 2, 3, 4, 5, 6)

  println("fold:" + n.fold(-21)(_ + _))
  println("reduce:" + n.reduce(_ + _))

  List.empty[Int] reduce (_ + _)
}
