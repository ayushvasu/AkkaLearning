package com.ayush.three

import akka.actor.{Actor, ActorRef, Terminated}

class Parent(child: ActorRef) extends Actor {
  override def preStart(): Unit = {
    context.watch(child)
  }

  override def receive= {
    case Terminated(x) =>
      println("Child is terminated : "+x.path)
      context.stop(self)
    case msg => println("Parent got message "+msg)
  }
}
