package com.marionette.training.chapter10

object MonoidApp extends App {

  val v = Vector(1, 2, 3, 4)
  println(Monoid.sum(v))
}

trait Monoid[T] {
  def op(x: T, y: T): T

  def zero: T
}

object Monoid {

  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
    override def op(x: Int, y: Int): Int = x + y

    override def zero: Int = 0
  }

  def sum[T, M[A] <: {def foldLeft[B](b : B)(fn : (B, A) => B) : B}](xs: M[T])(implicit monoid: Monoid[T]): T = {
    xs.foldLeft(monoid.zero)(monoid.op)
  }
}