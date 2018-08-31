package com.ayush.three

import akka.actor.Actor

class Child extends Actor{
  override def receive = {
    case msg =>
      println(s"child received ${msg}")
      context.stop(self)
  }

}
