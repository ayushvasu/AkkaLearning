package com.ayush.eleven_PersistentFSM


import scala.reflect._
import akka.persistence.fsm._
import akka.persistence.fsm.PersistentFSM.FSMState


object Account {

  //State
  sealed trait State extends FSMState

  case object Empty extends State {
      override def identifier: String = "Empty"
    }

  case object Active extends State {
      override def identifier: String = "Empty"
    }

  //Data
  sealed trait Data {
    val amount: Int
  }

  case object ZeroBalance extends Data {
      override val amount : Int = 0
    }

  case class Balance(override val amount : Int) extends Data

  //Domain Event
  sealed trait DomainEvent
  case class AcceptTransaction(amount: Int, `type`: TransactionType) extends DomainEvent
  case class RejectTransaction(amount: Int, `type`: TransactionType, reason: String) extends DomainEvent

  //TransactionType
  sealed trait TransactionType
  case object CR extends TransactionType
  case object DR extends TransactionType


  //Operation
  case class Operation(amount: Int, `type`: TransactionType)
}

class Account extends PersistentFSM[Account.State,Account.Data,Account.DomainEvent]{
  import Account._
  override def persistenceId: String = "account"

  override def applyEvent(domainEvent: DomainEvent, currentData: Data): Data = {
    domainEvent match {
      case AcceptTransaction(amount, CR) =>
        val newAmount = currentData.amount + amount
        println(s"Your new balance is $newAmount")
        Balance(currentData.amount + amount)
      case AcceptTransaction(amount, DR) =>
        val newAmount = currentData.amount - amount
        println(s"Your new balance is $newAmount")
        if(newAmount > 0)
          Balance(newAmount)
        else
          ZeroBalance
      case RejectTransaction(_, _, reason) =>
        println(s"RejectedTransaction with reason: $reason")
        currentData
    }
  }

  override def domainEventClassTag: ClassTag[DomainEvent] = classTag[DomainEvent]

  startWith(Empty, ZeroBalance)
  when(Empty){
    case Event(Operation(amount, CR),_)=>
      println(s"Zero to action $amount")
      goto(Active) applying AcceptTransaction(amount,CR)
    case Event(Operation(amount, DR),_)=>
      println(s"Sorry no balance")
      stay applying RejectTransaction(amount,DR,"Balance is Zero")
  }
  when(Active){
    case Event(Operation(amount, CR),_)=>
      stay applying AcceptTransaction(amount,CR)
    case Event(Operation(amount, DR),balance)=>
      val newBalance = balance.amount - amount
      if(newBalance > 0)
        stay applying AcceptTransaction(amount, CR)
      else if(newBalance == 0)
        goto(Empty) applying AcceptTransaction(amount,CR)
      else
        stay applying RejectTransaction(amount, CR, "Insufficient balance")
  }
}
