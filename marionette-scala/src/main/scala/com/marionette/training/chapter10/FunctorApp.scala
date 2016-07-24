package com.marionette.training.chapter10

object FunctorApp extends App {
  val fii: Int => Int = i => i * 2
  val fid: Int => Double = i => 2.1 * i
  val fds: Double => String = d => d.toString

  println(SeqF.map(List(1, 2, 3, 4))(fii))
  println(SeqF.map(List.empty[Int])(fii))

  println(OptionF.map(Some(2))(fii))
  println(OptionF.map(Option.empty[Int])(fii))

  val fa = FunctionF.map(fid)(fds)
  println(fa(2))
}


trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

object SeqF extends Functor[Seq] {
  def map[A, B](seq: Seq[A])(f: A => B): Seq[B] = seq.map(f)
}

object OptionF extends Functor[Option] {
  def map[A, B](opt: Option[A])(f: A => B): Option[B] = opt.map(f)
}

object FunctionF {
  def map[A, A2, B](func: A => A2)(f: A2 => B): A => B = {
    val functor = new Functor[({type λ[β] = A => β})#λ] {
      def map[A3, B](func: A => A3)(f: A3 => B): A => B = (a: A) => f(func(a))
    }

    functor.map(func)(f)
  }
}