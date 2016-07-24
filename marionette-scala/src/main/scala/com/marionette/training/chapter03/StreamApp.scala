package com.marionette.training.chapter03

object StreamApp extends App {
  lazy val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n =>
    println("Evaluating: %s -> %s".format(n._1, n._2))
    n._1 + n._2
  }

  fibs.take(10).foreach(println)

  fibs.take(11).foreach(println)
}

/*
  final class StreamIterator[+A](self: Stream[A]) extends Iterator[A] {
    class LazyCell(st: => Stream[A]) {
      // Note the laziness
      lazy val v = st
    }
    private var these = new LazyCell(self)
    def next: A =
      if (isEmpty) Iterator.empty.next
      else {
        // Evaluate the laziness
        val cur = these.v
        // And the concrete value of type A
        val result = cur.head
        // Assign the next lazy cell to be the Stream in the tail
        these = new LazyCell(cur.tail)
        result
      }
  }

 */
