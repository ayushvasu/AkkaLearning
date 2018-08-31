package com.ayush.seven_Path

import akka.actor.{ActorSystem, Props}

object Main extends App {

  val actorSystem = ActorSystem("actorPath")

  val sample = actorSystem.actorOf(Props[Sample],"sample")
  val getSample = actorSystem.actorOf(Props[GetSample],"GetSample")

  Thread.sleep(1000)
  actorSystem.terminate()
}
