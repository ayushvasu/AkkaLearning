package com.ayush.one

import akka.actor.{ ActorSystem, Props, Actor }

case class WhoToGreet(name: String)

class GreeterActor extends Actor {
  override def receive: Receive = {
    case WhoToGreet(name) => println(s"Hello $name !!!")
    case _ => println("F....K  Y...U")
  }
}

object Main extends App{
  val actorSystem = ActorSystem("HelloWorld")
  val greeterActor = actorSystem.actorOf(Props[GreeterActor],"greeterActor")

  greeterActor ! "ayush"

  greeterActor ! WhoToGreet("ayush")

  actorSystem.terminate()
}
