package com.ayush.two

import Helper._
import akka.actor.Actor

class Helper extends Actor {
  override def receive: Receive = {

    case Checker.Check(name) =>
      if(name.contains("ayush"))
        sender() ! White
      else
        sender() ! Black

    case msg => println("F....K  Y...U")
  }
}

object Helper {

  sealed trait status

  case object White extends status

  case object Black extends status

}
