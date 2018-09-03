package com.ayush.nine_SendingMessageViaRouter

import akka.actor.{ActorSystem, Props}
import akka.routing.{FromConfig, RandomGroup, RoundRobinPool}

object Main extends App {
  import Worker._

  val system = ActorSystem("router")

  val router = system.actorOf(Props[Router])

  router ! Work()

  router ! Work()

  router ! Work()

  router ! Work()

  Thread.sleep(1000)
  println("=-=-=-=-=-=-Router Group=-=-=-=-=-=-=-=")
  

  system.actorOf(Props[Worker], "w1")
  system.actorOf(Props[Worker], "w2")
  system.actorOf(Props[Worker], "w3")
  system.actorOf(Props[Worker], "w4")
  system.actorOf(Props[Worker], "w5")

  val worker: List[String] = List("/user/w1","/user/w2","/user/w3","/user/w4","/user/w5")

  val routerGroup = system.actorOf(Props(classOf[RouterGroup],worker))

  routerGroup ! Work()
  routerGroup ! Work()
  routerGroup ! Work()
  routerGroup ! Work()
  routerGroup ! Work()

  Thread.sleep(1000)
  println("=-=-=-=-=--=-=-Random Router actor=-=-=--=--=-=-=-=-=")
  

  val routerPool = system.actorOf(FromConfig.props(Props[Worker]),"random-router-pool")

  routerPool ! Work()
  routerPool ! Work()
  routerPool ! Work()
  routerPool ! Work()
  routerPool ! Work()


  Thread.sleep(1000)
  println("=-=-=-=-=--=-=-Random Group Router actor=-=-=--=--=-=-=-=-=")

  system.actorOf(Props[Worker], "w11")
  system.actorOf(Props[Worker], "w21")
  system.actorOf(Props[Worker], "w31")

  val paths = List("/user/w11","/user/w21","/user/w31")

  val routerGroup2 = system.actorOf(RandomGroup(paths).props(), "random-group-router")

  routerGroup2 ! Work()
  routerGroup2 ! Work()
  routerGroup2 ! Work()
  routerGroup2 ! Work()


  Thread.sleep(1000)
  println("-=-=-=-=-=-=-round-robin part 1=-=-=-==-=-=-=")

  val routerPool2 = system.actorOf(RoundRobinPool(3).props(Props[Worker]), "round-robin-pool")

  routerPool2 ! Work()

  routerPool2 ! Work()

  routerPool2 ! Work()

  routerPool2 ! Work()


  Thread.sleep(1000)
  println("-=-=-=-=-=-=-round-robin part 2=-=-=-==-=-=-=")
  system.actorOf(Props[Worker], "w12")
  system.actorOf(Props[Worker], "w22")
  system.actorOf(Props[Worker], "w23")

  val routerGroup3 = system.actorOf(FromConfig.props(), "round-robin-group")

  routerGroup3 ! Work()

  routerGroup3 ! Work()

  routerGroup3 ! Work()

  routerGroup3 ! Work()

  Thread.sleep(1000)

  system.terminate()

}
/*
* Round Robin
* Balancing
* Smallest MailBox
* BroadCast
* Scatter Gather First Complete
* Consistent Hashing
* Tail Chopping
* */