package com.ayush.two

import akka.actor.{Actor, ActorRef}
import Checker._
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import Helper._

class Checker(helper: ActorRef) extends Actor {
  import scala.concurrent.ExecutionContext.Implicits.global

  implicit val timeout = Timeout(5 second)


  override def receive: Receive = {

    case Save(name) =>
      helper ? Check(name) map {
        case White =>
          println("Saving name to data base!!!!!")

        case Black =>
          println("Not Saving to Data Base!!!!!!")

        case _ => println("Kuch Nahi Ho Sakta")
      }

    case msg => println("F....K  Y...U")
  }
}

object Checker {

  sealed trait operation

  case class Save(name: String) extends operation

  case class Check(name: String) extends operation

  case object show extends operation

}
