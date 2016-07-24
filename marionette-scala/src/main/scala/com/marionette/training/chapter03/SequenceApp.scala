package com.marionette.training.chapter03

object SequenceApp extends App {
  val seq = Seq("1", "2", 3, 11.1)
  println(seq)

  val seq1 = "1" +: "2" +: 3 +: 11.1 +: Seq.empty
  println(seq1)

  val seq2 = Seq.empty.:+(11.1).+:(3).+:("2").+:("1")
  println(seq2)

  println(seq1 ++ seq2)

  val lst = List("1", "2", 3, 11.1)
  println(lst)

  val lst1 = "1" +: "2" +: 3 +: 11.1 +: Nil
  println(lst1)

  val lst2 = "1" :: "2" :: 3 :: 11.1 :: Nil
  println(lst2)

  println(lst1 ++ lst2)


  println(Array(Array(11), Array(21, 22)) == Array(Array(11), Array(21, 22)))
}
