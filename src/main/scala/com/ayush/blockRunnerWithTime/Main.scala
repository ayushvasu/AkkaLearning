package com.ayush.blockRunnerWithTime

object Main extends App {

  val util = new Util

  val (a, timeTaken1) = util.profile{
    try {
      10 / 0
    }catch{
      case e : Exception => println(e.getMessage)
        "Exception " + e.getMessage
    }
  }

  println(s"a :: $a")

  println(s"timeTaken1 :: $timeTaken1")

  val (b, timeTaken2) = util.profile{
    try {
      10 / 3
    }catch{
      case e : Exception => println(e.getMessage)
    }
  }

  println(s"b :: $b")

  println(s"timeTaken2 :: $timeTaken2")

}
