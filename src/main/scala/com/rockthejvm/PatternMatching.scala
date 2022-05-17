package com.rockthejvm

object PatternMatching extends App {
  //switch expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "Second"
    case 3 => "Third"
    case _ => anInteger + "th"
  }
  //PM is an expression
  println(order)

  //case class decomposition
  case class Person(name: String, age: Int)

  val bob = Person("bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi I'm $n and I'm $a years old"

  }
  println(personGreeting)
  //deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belong to the genre $genre"
    case _ => "I don't know what are you talking about"
  }
  //decomposing lists
  val aList = List(1, 2, 3)
  val listDescription = aList match {
    case List(_, 2, _) => "List contains 2 on the second position"
    case _ => "Unknown List"
  }
  println(listDescription)

}
