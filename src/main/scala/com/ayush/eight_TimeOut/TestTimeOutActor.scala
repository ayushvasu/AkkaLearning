package com.ayush.eight_TimeOut

import akka.actor.Actor

class TestTimeOutActor extends Actor {

  override def receive: Receive = {
    case msg =>
      println(s"Mast $msg")
      Thread.sleep(1000)
      println("step 1")
      Thread.sleep(1000)
      println("step 2")
      Thread.sleep(1000)
      println("step 3")
      Thread.sleep(1000)
      println("step 4")
      Thread.sleep(1000)
      println("step 5")
      sender ! "Ho-Gaya-pura"
  }

}
