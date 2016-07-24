package com.marionette.training.chapter09

object TypeProjection extends App {

  val a1 = new A
  val a2 = new A

  a1.foo(new a1.B)
  /*
  val l1: Service1.Log   = new ConsoleLogger

  val l2: Service2.Log  = new ConsoleLogger

  val l3: Service1#Log   = new ConsoleLogger

  val l4: Service2#Log  = new ConsoleLogger
  */
}


class A {

  class B {
    override def toString = getClass.getCanonicalName
  }

  def foo(b: B) = println(b)

}

trait Logger {
  def log(message: String): Unit
}

class ConsoleLogger extends Logger {
  def log(message: String): Unit = println(s"log: $message")
}

trait Service1 {
  type Log <: Logger
  val logger: Log
}

class Service2 extends Service1 {
  type Log = ConsoleLogger
  val logger: ConsoleLogger = new ConsoleLogger
}