package com.marionette.training.chapter09


class C1 {
  var x = "1"
  def setX1(x:String): Unit = {
    println("C1::setX1")
    this.x = x
  }
  def setX2(x:String): Unit = {
    println("C1:setX2")
    C1.this.x = x
  }
}

trait X {
  def setXX(x:String): Unit = {println("X:setXX")}
}


class C2 extends C1
{
  override def setX1(x: String): Unit = {println("C2:setX1")}
}

class C3 extends C2 with X {
  def setX3(x: String): Unit = super.setX1(x)

  def setX4(x: String): Unit = C3.super.setX1(x)

  def setX5(x: String): Unit = C3.super[C2].setX1(x)

  def setX6(x: String): Unit = C3.super[X].setXX(x)
}

object C3 extends App {
  val c3 = new C3
  c3.setX3("me3")
  c3.setX4("me4")
  c3.setX5("josie")
  c3.setX6("Jose")
}