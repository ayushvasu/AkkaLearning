package com.ayush.two

import akka.actor.{ActorSystem, Props}
import Checker._

object Main extends App {

  val actorSystem = ActorSystem("Two")

  val helper = actorSystem.actorOf(Props[Helper], "helper")

  val checker = actorSystem.actorOf(Props(classOf[Checker],helper),"checker")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  checker ! Save("ayush")

  checker ! Save("YOYO")

  Thread.sleep(100)

  checker ! "YOYO"

  actorSystem.terminate()
}
