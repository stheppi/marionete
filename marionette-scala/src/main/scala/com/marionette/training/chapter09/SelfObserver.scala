package com.marionette.training.chapter09

abstract class SelfObserver {
  type S <: Subject
  type O <: Observer

  trait Subject {
    self: S =>
    private var observers = List[O]()

    def addObserver(observer: O): Unit = observers ::= observer

    def notifyObservers() = observers.foreach(_.receiveUpdate(self))
  }

  trait Observer {
    def receiveUpdate(subject: S)
  }

}
