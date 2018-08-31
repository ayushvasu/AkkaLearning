package com.ayush.six_FSMBasic

import akka.actor.{ActorSystem, Props}

object Main extends App {
  import ChangeRunner._

  val system = ActorSystem("Hotswap-FSM")

  val userStorage = system.actorOf(Props[ChangeRunner], "userStorage-fsm")

  userStorage ! Operation(DBOperation.Create, User("Admin1", "admin@packt.com"))

  userStorage ! Operation(DBOperation.Create, User("Admin2", "admin@packt.com"))

  userStorage ! Connect

  userStorage ! Operation(DBOperation.Create, User("Admin3", "admin@packt.com"))

  userStorage ! Disconnect

  Thread.sleep(100)

  system.terminate()

}
