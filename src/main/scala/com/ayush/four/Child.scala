package com.ayush.four

import akka.actor.Actor

class Child extends Actor {
  import Child._

  override def preStart() = {
    println("Child preStart hook....")
  }

  override def preRestart(reason: Throwable, message: Option[Any]) = {
    println("Child preRestart hook...")
    super.preRestart(reason, message)
  }

  override def postRestart(reason: Throwable) = {
    println("Child postRestart hook...")
    super.postRestart(reason)
  }

  override def postStop() = {
    println("Child postStop...")
  }
  

  override def receive = {
    case "Resume" =>
      println("Child Resume")
      throw ResumeException
    case "Stop" =>
      throw StopException
    case "Restart" =>
      throw RestartException
    case _ =>
      throw new Exception
  }

}

object Child{
  case object ResumeException extends Exception
  case object StopException extends Exception
  case object RestartException extends Exception
}