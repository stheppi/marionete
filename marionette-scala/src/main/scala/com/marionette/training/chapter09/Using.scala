package com.marionette.training.chapter09

import scala.util.Random

trait Using {
  def using[R, T <: {def close() : Unit}](fn: () => T)(thunk: T => R): R = {
    val t = fn()
    try {
      thunk(t)
    }
    finally {
      t.close()
    }
  }
}

class SomeAutoclosable extends AutoCloseable {
  override def close(): Unit = println(s"${getClass.getName}::close")

  def foo(): Int = Random.nextInt()
}

class Some {
  def close(): Unit = s"${getClass.getName}::close"

  def foo1(): Double = Random.nextDouble()
}

object UsingExample extends App with Using {
  val x = using(() => new SomeAutoclosable) { t =>
    t.foo()
  }
  println(s"x=$x")

  val d = using(() => new Some()) { s => s.foo1() }
  println(s"d=$d")
}