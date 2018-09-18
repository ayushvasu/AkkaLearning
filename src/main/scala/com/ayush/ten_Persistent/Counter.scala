package com.ayush.ten_Persistent

import akka.actor.ActorLogging
import akka.persistence._

object Counter{
  sealed trait Operation{
    val count : Int
  }
  case class increment(override val count : Int) extends Operation
  case class decrement(override val count : Int) extends Operation

  case class Evt(opr: Operation) // for event
  case class Cmd(opr: Operation) // for command

  case class State(count : Int) // for state
}

class Counter extends PersistentActor with ActorLogging {
  import Counter._
  println("Starting ...............  ")

  var state: State = State(count= 0)

  def updateState(evt: Evt): Unit = evt match {
    case Evt(increment(count)) =>
      state = State(count = state.count + count)
    case Evt(decrement(count)) =>
      state = State(count = state.count - count)
  }

  //persistent receive on recovery mood
  override def receiveRecover: Receive = {
    case evt:Evt =>
      println(s"counter receive $evt on recovering mood")
      updateState(evt)
      takeSnapshot
    case SnapshotOffer(_, snapshot: State) =>
      println(s"counter receive snap shot with data $snapshot on recovering mood")
      state = snapshot
  }

  //persistent receive on normal mood
  override def receiveCommand: Receive = {
    case cmd @Cmd(opr) =>
      println(s"counter receive $cmd")
      persist(Evt(opr)){
        evt =>
          updateState(evt)
      }
    case SaveSnapshotSuccess(metadata) =>
      println(s"save snapshot success")

    case SaveSnapshotFailure(metadata, reason) =>
      println(s"failure while saving snap shot $reason ::: $metadata")
    case "print" =>
      println(s"The Current state of counter is ${state}")
  }

  def takeSnapshot = {
    //println(s"called with $state")
    if(state.count % 5 == 0)
      saveSnapshot(state)
  }

  //persistent identifier
  override def persistenceId: String = "Counter-Example"
}
