package com.marionette.training

import com.typesafe.scalalogging.slf4j.StrictLogging

trait Timed extends StrictLogging {

  def timed(thunk: => Unit): Long = {
    val start = System.nanoTime()
    val t = thunk
    val end = System.nanoTime()
    end - start

  }
}
