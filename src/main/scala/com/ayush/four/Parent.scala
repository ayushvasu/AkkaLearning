package com.ayush.four

import scala.language.postfixOps
import scala.concurrent.duration._
import akka.actor.OneForOneStrategy
import akka.actor.SupervisorStrategy._
import akka.actor.{ ActorRef, Props, Actor }

class Parent extends Actor {
  import Child._

  var childRef: ActorRef = _

  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 second) {
      case ResumeException      => Resume
      case RestartException     => Restart
      case StopException        => Stop
      case _: Exception         => Escalate
    }


  override def preStart() = {
    childRef = context.actorOf(Props[Child], "Aphrodite")
    Thread.sleep(100)
  }

  def receive = {
    case msg =>
      println(s"Parent received ${msg}")
      childRef ! msg
      Thread.sleep(100)
  }
}