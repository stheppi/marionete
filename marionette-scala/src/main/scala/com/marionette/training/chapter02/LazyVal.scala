package com.marionette.training.chapter02

final class LazyVal {
  @volatile
  private var flag: Boolean = false

  private var value_0: Int = _

  private def lazyCompute(): Int = {
    this.synchronized {
      if (!flag) {
        value_0 = 42
        flag = true
      }
    }
    value_0
  }

  def value = if (flag) value_0 else lazyCompute()
}

object LazyValApp extends App {
  val cell = new LazyVal
  println(cell.value)
}
