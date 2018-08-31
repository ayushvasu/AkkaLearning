package com.ayush.three

import akka.actor.{ActorSystem, Props}

object Main extends App {

  val actorSystem = ActorSystem("Monitoring")

  val child = actorSystem.actorOf(Props[Child],"child")

  val parent = actorSystem.actorOf(Props(classOf[Parent],child),"parent")

  child ! "baharo phul barsao!!!"

  Thread.sleep(100)

  actorSystem.terminate()
}
