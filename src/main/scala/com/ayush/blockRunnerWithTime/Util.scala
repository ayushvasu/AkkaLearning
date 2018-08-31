package com.ayush.blockRunnerWithTime

class Util {
  val nanoSecsInMilliSec = 1000000L
  def profile[R](codeBlock: => R): (R, Long) = {
    val t0 = System.nanoTime()
    val result = codeBlock
    (result, (System.nanoTime() - t0)/nanoSecsInMilliSec)
  }
}
