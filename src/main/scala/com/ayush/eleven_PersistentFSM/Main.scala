package com.ayush.eleven_PersistentFSM

import akka.actor.{ActorSystem, Props}

object Main extends App {
  import Account._

  val system = ActorSystem("FSMPersistent")

  val account = system.actorOf(Props[Account], "Account")

  account ! Operation(1000, CR)

  account ! Operation(100, DR)

  Thread.sleep(1000)

  system.terminate()

}
