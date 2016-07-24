package com.marionette.training.chapter07

/**
  * Created by stepi on 13/07/16.
  */
case class Quote(symbol: String, price: BigDecimal)

object CaseClassApp extends App {

  val quote = Quote("GBPEUR=X", BigDecimal(1.21))
  println(quote)

  val quoteCreator: (String, BigDecimal) => Quote = Quote.apply

  val gbpUsdQuote = quoteCreator("GBPUSD=X", BigDecimal(1.499))
  println(gbpUsdQuote)

  val quoteBuilder: String => BigDecimal => Quote = Quote.curried

  val eurUSDQuote = quoteBuilder("EURUSD=X")(BigDecimal(1.12))
  println(eurUSDQuote)
}
