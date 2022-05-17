package com.rockthejvm

object FunctionalProgramming extends App {
  //Scala is Oo
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(63)
  bob(63) //INVOKING bob as function
  /*
  Scala runs on the JVM
  Functional programming;
  - compose functions
  - pass functions as args
  - return as result

  Conclusion: FunctionX = Function1, Function2, ... Funcion22
   */
  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }
  simpleIncrementer.apply(32) //24
  simpleIncrementer(23) //Same as simpleIncrementer.apply(23)
  //defined as a function!

  //ALL SCALA FUNCTIONS ARE INSTANCES OF THE FUNCTION_X TYPE
  val stringConcatenator = new Function2[String, String, String] { //arg1, arg2, return type
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }
  stringConcatenator("I love", "Scala") //I love Scala

  //syntax sugars
  val doubler: Int => Int = (x: Int) => 2 * x
  //  val doubler = (x: Int) => 2 * x //also valid
  doubler(4) // 8
  /*
  Equivalent to the much longer:

  new Function1[Int, Int] {
  override def appy(x: Int) = 2 * x
  }

  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
   */

  // Higher-order functions: take functions as args/return functions as result
  val aMappedList = List(1, 2, 3).map(x => x + 1) //HOF Higher-Order-Function
  println(aMappedList) //(2,3,4)
  //  val aFlatMappedList = List(1, 2, 3).flatMap(x => List(x, 2 * x))
  //Alternative Syntax
  val aFlatMappedList = List(1, 2, 3).flatMap { x =>
    List(x, 2 * x)
  }
  println(aFlatMappedList)

  //  val aFilteredList = List(1, 2, 3, 4, 5).filter(x => x % 2 == 0) //return only even numbers
  //  val aFilteredList = List(1, 2, 3, 4, 5).filter(x => x <= 3) //return only even numbers
  val aFilteredList = List(1, 2, 3).filter(_ <= 3) //same as (x => x <= 3)
  println(aFilteredList)

  //all pairs between the numbers 1,2,3 and the letters 'a', 'b' , 'c'
  val abcList = List('a', 'b', 'c')
  val allPairs = List(1, 2, 3).flatMap(num => abcList.map(letter => s"$num-$letter"))
  println(allPairs)

  //for comprehensions
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  println(alternativePairs)

  //lists
  val aList = List(1, 2, 3)
  val firstElement = aList.head //head: will return first element
  val rest = aList.tail // tail: will return the rest of elements after head or given index tail(1)

  println(s"List Head $firstElement")
  println(s"Rest $rest")

  val aPrependedList = 0 :: aList
  println(aPrependedList) //List(0,1,2,3)

  val anExtendedList = 0 +: aList :+ 4
  println(anExtendedList) // 0 , 1 , 2 , 3 , 4
  println(anExtendedList)
  //sequances
  val aSequence: Seq[Int] = Seq(1, 2, 3) //Seq.apply(1,2,3)
  val accessedElement = aSequence(1)
  println(accessedElement)

  //vectors: fast Seq implementation
  val aVector = Vector(1, 2, 3, 4)

  //Sets
  val aSet = Set(1, 2, 3, 4, 1, 2, 3)
  println(s"A Set $aSet")
  val setHas5 = aSet.contains(5)
  println(setHas5)

  val anAddedSet = aSet + 5 //will add 5 to the set
  println(anAddedSet)

  val aRemovedSet = aSet - 2 //will remove 2 from the set
  println(aRemovedSet)

  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList //same as (2 * _)
  //toSet toSeq can be used as well
  println(twoByTwo)

  //tuples = group of values under same value
  val aTuple = ("Bon Jovi", "Rock", 1093)

  //Maps
  val aPhoneBook: Map[String, Int] = Map(
    ("Danial", 234124),
    ("Jane", 23424),
    "Sam" -> 234123 //also valid
  )
  println(aPhoneBook)

  
}
