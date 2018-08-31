package com.ayush.four

import akka.actor.{ActorSystem, Props}

object Main extends App {
  val actorSystem = ActorSystem("Monitoring")

  val parent = actorSystem.actorOf(Props(classOf[Parent]),"parent")

  parent ! "Restart"

  Thread.sleep(10000)

  println("Stopping all")

  actorSystem.terminate()
}
