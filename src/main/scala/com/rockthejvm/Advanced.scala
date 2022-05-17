package com.rockthejvm

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object Advanced extends App {

  //lazy evaluation - value won't be evaluated untill it's first use
  lazy val alazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am  so very lazy!")
    43
  }

  val eagerValue = lazyValueWithSideEffect + 1
  // usful in infinite collection

  /** "pseudo-collections" : Option , try */
  def methodWhichCanReturnNull(): String = "hello, Scala"

  val anOption = Option(methodWhichCanReturnNull()) //Some("hello, Scala")
  // option = "collection which contains at most one element: Some(value) or None
  val strigProcessing = anOption match {
    case Some(string) => s"I have valid string $string"
    case None => "I obtained nothing"
  }
  //map, flatMap, filter

  def methodWhichCanThrowException(): String = throw new RuntimeException

  val aTry = Try(methodWhichCanThrowException())

  //a try = "collection" with either a value if the code went well or exception if the code throw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a string $validValue"
    case Failure(exception) => println(exception)
  }
  //map, flatMap, filter


  /**
   * Evaluate something on another thread
   * (asynchronous programming)
   */
  val aFuture = Future({
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed value")
    85
  })
  Thread.sleep(2000)
  //future is a "collection" which contains a value when it's evaluated
  //future is composable with map, flatMap, and filter
  // monads

  /**
   * Implicits basics
   */
  //#1: implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1

  implicit val myImplicitInt = 64
  print(aMethodWithImplicitArgs) //aMethodWithImplicitArgs(64) //the compiler will figure it out

  //#2: Implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven()) // new MyRichInteger(23.isEven())
}
