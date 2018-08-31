package com.ayush.five_Become

import akka.actor.{ ActorSystem, Props }

object Main extends App {
  import Runner._

  val system = ActorSystem("Hotswap-Become")

  val userStorage = system.actorOf(Props[Runner], "userStorage")


  userStorage ! Operation(DBOperation.Create, Some(User("Admin1", "admin@packt.com")))
  userStorage ! Operation(DBOperation.Create, Some(User("Admin2", "admin@packt.com")))
  userStorage ! Operation(DBOperation.Create, Some(User("Admin3", "admin@packt.com")))
  userStorage ! Operation(DBOperation.Create, Some(User("Admin4", "admin@packt.com")))
  userStorage ! Operation(DBOperation.Create, Some(User("Admin5", "admin@packt.com")))
  userStorage ! Connect

  userStorage ! Disconnect
  userStorage ! Operation(DBOperation.Create, Some(User("Admin6", "admin@packt.com")))
  userStorage ! Operation(DBOperation.Create, Some(User("Admin7", "admin@packt.com")))
  userStorage ! Connect

  Thread.sleep(10000)

  system.terminate()
}
