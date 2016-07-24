package com.marionette.training.chapter09

object HKTTwo extends App {

  import Add._
  import Reduce._

  def sum[T: Add, M[T]](container: M[T])(implicit redFn: Reduce[T, M]): T = {
    redFn.reduce(container)(implicitly[Add[T]].add(_, _))
  }

  println(sum(Vector(1 -> 10, 2 -> 20, 3 -> 30)))
  println(sum(1 to 10))
  println(sum(Option(2)))

  //println(sum[Int, Option](None))


  def sum1[T: Add, M[_] : Reduce1](container: M[T]): T = {
    implicitly[Reduce1[M]].reduce(container)(implicitly[Add[T]].add(_, _))
  }

  println(sum1(Vector(1 -> 10, 2 -> 20, 3 -> 30)))
  println(sum1(1 to 10))
  println(sum1(Option(2)))
  println(sum1[Int, Option](None))
}

//why contravariant??
trait Reduce[T, -M[T]] {
  def reduce(m: M[T])(f: (T, T) => T): T
}

object Reduce {
  implicit def seqReduce[T]: Reduce[T, Seq] = new Reduce[T, Seq] {
    def reduce(seq: Seq[T])(f: (T, T) => T): T = seq.reduce(f)
  }

  implicit def optionReduce[T]: Reduce[T, Option] = new Reduce[T, Option] {
    def reduce(opt: Option[T])(f: (T, T) => T): T = opt.reduce(f)
  }
}

//M is the higher-kinded type
trait Reduce1[-M[_]] {
  def reduce[T](m: M[T])(f: (T, T) => T): T
}

object Reduce1 {
  implicit val seqReduce: Reduce1[Seq] = new Reduce1[Seq] {
    def reduce[T](seq: Seq[T])(f: (T, T) => T): T = seq.reduce(f)
  }

  implicit val optionReduce: Reduce1[Option] = new Reduce1[Option] {
    def reduce[T](opt: Option[T])(f: (T, T) => T): T = opt.reduce(f)
  }
}