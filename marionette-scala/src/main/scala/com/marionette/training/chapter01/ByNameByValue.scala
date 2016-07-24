package com.marionette.training.chapter01

import scala.util.Random

object ByNameByValue extends App {
  def double(x: Int) = x * 2

  println(double(10))

  def fnByName(x: => Int) = {
    println("In fnByName")
    x * 2
  }

  println(fnByName({
    println("Computing integer")
    val i = Random.nextInt()
    i % 10
  }))


  def continue(conditional: => Boolean)(body: => Unit) {
    if (conditional) {
      body
      continue(conditional)(body)
    }
  }

  var count = 0
  continue(count < 5) {
    println(s"at $count")
    count += 1
  }
}
