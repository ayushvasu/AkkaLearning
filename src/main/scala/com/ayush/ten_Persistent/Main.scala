package com.ayush.ten_Persistent

import akka.actor.{ ActorSystem, Props }

object Main extends App {
  import Counter._

  val system = ActorSystem("persistent-actors")

  val counter = system.actorOf(Props[Counter])

  counter ! Cmd(increment(3))

  counter ! Cmd(increment(5))

  counter ! Cmd(decrement(3))

  counter ! "print"

  Thread.sleep(1000)

  system.terminate()

}
