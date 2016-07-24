package com.marionette.training.chapter03


object MapAndFlatMap extends App {
  val seq = Vector("now", "is", "", "the", "time")
  val len = seq.map(_.length)

  println(seq.zip(len))
  //seq.zipWithIndex

  println(seq.flatMap(_.toList))

  val countriesAndCapital = Map("Portugal" -> "Lisabona",
    "France" -> "Paris",
    "Germany" -> "Berlin",
    "Columbia" -> "Bogota")

  val f: (String, String) => Boolean = (c, capital) => capital.startsWith("B")
  val wFilter = countriesAndCapital.withFilter { case (country, capital) => f(country, capital) }
  val filtered = countriesAndCapital.filter { case (a, c) => f(a, c) }

  wFilter.map(_._1).foreach(println)
  filtered.map(_._1).foreach(println)
}
