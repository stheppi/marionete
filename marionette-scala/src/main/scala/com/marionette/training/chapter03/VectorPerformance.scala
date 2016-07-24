package com.marionette.training.chapter03

import com.marionette.training.Timed

import scala.collection.mutable
import scala.concurrent.duration._

object VectorPerformance extends App with Timed {
  val N = 5000
  val reps = 100

  var timeVector: Long = 0
  var timeArray: Long = 0
  var timeArrayBuffer: Long = 0
  var timeQueue: Long = 0

  for (k <- 0 until reps) {
    var myArray = Array.ofDim[Int](N + 1)
    val elapsed_prev3 = timed {
      (0 to N).foreach { i =>
        myArray(i) = i
        myArray.take(100).map(x => x * x).sum
      }
    }.nanos.toMillis
    timeArray += elapsed_prev3

    val buffer = mutable.ArrayBuffer.empty[Int]
    val elapsed_prev = timed {
      (0 to N).foreach { i: Int =>
        buffer += i
        buffer.take(100).map(x => x * x).sum
      }
    }.nanos.toMillis
    timeArrayBuffer += elapsed_prev

    var vector = Vector.empty[Int]
    val elapsed_prev2 = timed {
      (0 to N).foreach { i =>
        vector :+= i
        vector.take(100).map(x => x * x).sum
      }
    }.nanos.toMillis
    timeVector += elapsed_prev2

  }

  println("timeVector     : " + timeVector + "  avg = " + timeVector / reps)
  println("timeArrayBuffer: " + timeArrayBuffer + "  avg = " + timeArrayBuffer / reps)
  println("timeArray      : " + timeArray + "  avg = " + timeArray / reps)
}
