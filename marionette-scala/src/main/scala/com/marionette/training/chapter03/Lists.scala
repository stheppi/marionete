package com.marionette.training.chapter03

object Lists extends App {
  val l1 = 1 +: 2 +: 3 +: Nil
  val l2 = 1 :: 2 :: 3 :: List.empty
  val l3 = List.empty :+ 3 :+ 2 :+ 1

  println(l1.head)
  println(l3.head)

  def traverse(l: List[Int]): String = {
    def acc(current: List[Int], value: String): String = {
      current match {
        case List() => value + "+: Nil"
        case head +: tail =>
          acc(tail, s"$value+:$head")
      }
    }
    if (l.nonEmpty)
      acc(l.tail, l.head.toString)
    else
      "Empty"
  }

  println(traverse(l1))
}
