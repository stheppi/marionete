package com.marionette.training.chapter04

object ForComprehensionApp extends App {
  val countries = Vector("Portugal", "Romania", "UK", "France")

  for {
    c <- countries
  } println(c)

  countries.foreach(println)

  val countriesUppercase =
    for {
      c <- countries
    } yield c.toUpperCase

  println(countriesUppercase)
  println(countries.map(_.toUpperCase()))


  val countriesWithAndO =
    for {
      c <- countries
      if c.contains('o') && c.contains('a')
    } yield c.toUpperCase()

  println(countriesWithAndO)
  println(
    countries
      .withFilter(c => c.contains('o') && c.contains('a'))
      .map(_.toUpperCase)
  )


  val chars =
    for {
      country <- countries
      c <- country
    } yield c.toUpper

  println(chars)
  println(
    countries.flatMap(_.toSeq.map(_.toUpper))
  )


  val charsIfLower =
    for {
      country <- countries
      c <- country
      if c.isLower
    } yield s"${c.toUpper}$c"

  println(charsIfLower)
  println {
    countries.flatMap(_.toSeq.withFilter(_.isLower).map(c => s"${c.toUpper}$c"))
  }

}