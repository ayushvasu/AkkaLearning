package com.ayush.eight_TimeOut

import akka.actor.{ActorSystem, Inbox, PoisonPill, Props}

import scala.concurrent.duration._
import scala.language.postfixOps

object Main extends App {

  val actorSystem = ActorSystem("TestTimeout")

  val actor = actorSystem.actorOf(Props[TestTimeOutActor],"testTimeOutActor")

  val alertsInbox = Inbox.create(actorSystem)

  alertsInbox.send(actor, "Ayush")

  try{
    alertsInbox.receive(2 second)
  } catch {
    case e: java.util.concurrent.TimeoutException =>
      alertsInbox.send(actor, PoisonPill)
      println(s"TimeOutException "+ e.getMessage)

    case x: Exception =>
      println(s"Caught unexpected exception: ${x.getMessage}")
  }
  import scala.concurrent.ExecutionContext.Implicits.global
  println("Terminating")
  actorSystem.terminate().onSuccess{case x => println("x value : "+x)}
}
