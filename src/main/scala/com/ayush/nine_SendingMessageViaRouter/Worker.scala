package com.ayush.nine_SendingMessageViaRouter

import akka.actor.Actor

class Worker extends Actor {
  import Worker._
  override def receive: Receive = {
    case msg : Work =>
      println(s"I received work message and my actor Ref $self")
  }
}

object Worker {
  case class Work()
}
