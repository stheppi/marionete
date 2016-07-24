package com.marionette.training.chapter01

import scala.annotation.tailrec

object FactorialApp extends App {
  def factorial(n: Long): Long = {
    @tailrec
    def acc(v: Long, total: Long): Long = {
      if (v <= 0) total
      else acc(v - 1, v * total)
    }

    acc(n, 1)
  }

  println(factorial(5))
}

