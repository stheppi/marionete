package com.marionette.training.chapter03


object FoldLeftRight extends App {
  var shortList = 1 to 10 toList
  var longList = 1 to 325000 toList

  println(shortList.foldLeft("")((x, y) => "X"))
  println(shortList.foldRight("")((x, y) => "X"))


  println(longList.foldLeft("")((x, y) => "X"))
  println(longList.foldRight("")((x, y) => "X"))
}

/*

  def foldLeft[B](z: B)(f: (B, A) => B): B = {
    var acc = z
    var these = this
    while (!these.isEmpty) {
      acc = f(acc, these.head)
      these = these.tail
    }
    acc
  }

  def foldRight[B](z: B)(f: (A, B) => B): B = this match {
    case Nil => z
    case x :: xs => f(x, xs.foldRight(z)(f))
  }
 */