package com.marionette.training.chapter09


import scala.language.implicitConversions


object ViewBounds extends App {

  RemoteConnection.write(100)
  RemoteConnection.write(3.14f)
  RemoteConnection.write("hello!")
}

object Serialization {

  case class Writable(value: Any) {
    def serialized: String = s"-- $value --"
  }

  implicit def fromInt(i: Int): Writable = Writable(i)

  implicit def fromFloat(f: Float): Writable = Writable(f)

  implicit def fromString(s: String): Writable = Writable(s)
}


import com.marionette.training.chapter09.Serialization._

object RemoteConnection {
  def write[T <% Writable](t: T): Unit = {
    println(t.serialized)
  }
}