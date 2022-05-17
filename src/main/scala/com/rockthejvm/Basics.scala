package com.rockthejvm

object Basics extends App {
  //defining a value
  val meaningOfLif: Int = 42

  val aBoolean = false
  val aString = " I Love Scala "
  val anInterpolatedString = s"OK, $meaningOfLif"
  val anExpression = 2 + 2

  //if-expression
  val ifExpression = if (meaningOfLif > 43) 56 else 999

  val chainedIfExpression = {
    if (meaningOfLif > 43) 56
    else if (meaningOfLif < 0) -2
    else 0
  }

  //code blocks
  val aCodeBloc = {
    //defentions
    val aLocalValue = 23

    //value of last the block is the value of last expression
    aLocalValue + 10 //value of the block 33
  }

  //define function
  def myFunction(x: Int, y: String): String = y + " " + x

  def myFunctionBloc(x: Int, y: String): String = {
    y + " " + x
  }

  //recursive function
  def factorial(n: Int): Int = {
    if(n <=1) 1
    else n * factorial(n-1)
    /*
    * factorial(5) = 5*factorial(4) = 5*24 = 120
    * factirual(4) = 4*factorial(3) = 4*6
    * factirual(3) = 3*factorial(2) = 3*2
    * factirual(2) = 2*factorial(1) = 2*1
    * factirual(1) = 1 //now go up
    * */
  }
  //in Scala we don't use loops of iterations, we use RECURSION!

  //The unit type = no meaningul value == "void" in other languages
  //type of SIDE EFFECT
  println("I love Scala")

  def myUnitReturningFunction(): Unit = {
    println("I don't like returning Unit") //returns Unit "void"
  }
  val theUnit = ()
}
