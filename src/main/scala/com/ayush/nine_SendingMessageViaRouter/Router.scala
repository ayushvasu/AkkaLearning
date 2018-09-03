package com.ayush.nine_SendingMessageViaRouter

import akka.actor.{Actor, ActorRef, Props}

class Router extends Actor {

  var routees: List[ActorRef] = _

  override def preStart(): Unit = {
    routees = List.fill(5)(context.actorOf(Props[Worker]))
  }

  def receive() ={
    case msg : Worker.Work =>
      println("I am a router and receive a message ................")
      routees(util.Random.nextInt(routees.size)) forward msg
  }

}

class RouterGroup(routees: List[String]) extends Actor {
  override def receive: Receive = {
    case msg: Worker.Work =>
      println(s"I am Router group and I receive work message......"+routees(util.Random.nextInt(routees.size)))
      context.actorSelection(routees(util.Random.nextInt(routees.size))) forward msg
  }
}
