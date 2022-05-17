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

}
