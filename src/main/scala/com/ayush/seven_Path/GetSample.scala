package com.ayush.seven_Path

import akka.actor.{Actor, ActorIdentity, Identify}

class GetSample extends Actor{

  val sample1 = context.actorSelection("/user/sample")
  val sample2 = context.actorSelection("/user/smple")

  sample1 ! Identify(None)
  sample2 ! Identify(None)

  override def receive: Receive = {
    case ActorIdentity(_,  Some(ref)) =>
      println("Get Actor Identity :: "+ref)
    case ActorIdentity(_, None) =>
      println("Actor is not there")

  }

}
