package com.marionette.training.chapter06


object ValueClassApp extends App {

  class USPhoneNumber(val s: String) extends AnyVal {

    override def toString = {
      val digs = digits(s)
      val areaCode = digs.substring(0, 3)
      val exchange = digs.substring(3, 6)
      val subnumber = digs.substring(6, 10)
      s"($areaCode) $exchange-$subnumber"
    }

    private def digits(str: String): String = str.replaceAll("""\D""", "")
  }


  trait Digitizer extends Any {
    def digits(s: String): String = s.replaceAll("""\D""", "")
  }

  trait Formatter extends Any {
    def format(areaCode: String, exchange: String, subnumber: String): String = s"($areaCode) $exchange-$subnumber"
  }

  class USPhoneNumberWithTraits(val s: String) extends AnyVal with Digitizer with Formatter {
    override def toString = {
      val digs = digits(s)
      val areaCode = digs.substring(0, 3)
      val exchange = digs.substring(3, 6)
      val subnumber = digs.substring(6, 10)
      format(areaCode, exchange, subnumber)
    }

  }

  println(new USPhoneNumber("987-654-3210"))

  println(new USPhoneNumberWithTraits("987-654-3210"))
}
