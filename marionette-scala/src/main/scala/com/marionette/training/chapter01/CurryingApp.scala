package com.marionette.training.chapter01

/**
  * Created by stepi on 23/07/16.
  */
object CurryingApp extends App {
  def cat(s1: String, s2: String): String = s1 + s2

  def catCurried = (cat _).curried

  println(catCurried("hellow")(" world"))

  def catUncurried = Function.uncurried(catCurried)

  println(catUncurried("hello", "world"))
}
