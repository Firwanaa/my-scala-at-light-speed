package com.rockthejvm

object ObjectOrientation extends  App{
// java equivalent: public static void main(String[] args)
  
  //class and instance
  class Animal{
    //define fields
    val age: Int = 0
    //define methods
    def eat() = println("I'm eating")
  }
  val anAnimal = new Animal

  //inheritance
  class Dog(name: String) extends Animal //also constructor definition
  class Cat(val name: String) extends Animal //usign val keyword will make name as field as well

  val aDog = new Dog("lassie")
  //costructor arguments are NOT fields
  //aDog.name <- this will give error

  val aCat = new Cat("Nini")
 aCat.name //no problemo <- becase we used val keyword
  println(s"Cat name: ${aCat.name}")

  //subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hatchi")
  aDeclaredAnimal.eat() //the most derived method will be called at runtime

  //abstract class
  abstract class WalkingAnimal {
    protected val hasLegs = true //all fields and methods be default public can be restricted by private or protected
    def walk(): Unit
  }

  //"interface" = ultimate abstract type
  //emmm we can actually provide implementation inside trait but it's not a good practice
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit //valid method name
  }


  //single-class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("Eating you Animal")

    override def ?!(thought: String): Unit = println(s"I was thinking $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog //infix notaion = object method argument, only available for methods with one argument
  aCroc ?! "Some Ideas"

  //operators on Scala are actually methods
  val basicMath = 1+2
  val anotherBasicMath = 1.+(2) //equivalent

  //anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur")
  }
  /*
   // What you tell the compiler:
  class Carnivore_Anonymous_234 extends Carnivore {
     override def eat(animal: Animal): Unit = println("I am a dinosaur")
     }
     val dinosaur = new Carnivore_Anonymous_234
   */

  // singleton object
  object MySingelton {//the only instance of the MySingleton type
    val mySingeltonValue = 234523
    def mySpecialMethod(): Int = 234

    def apply(x: Int) : Int = x+1
  }
  MySingelton.mySpecialMethod()

  MySingelton.apply(3)
  //same as
  MySingelton(3)

  object Animal {//companions - companion object
    //companions can access each other's fields/methods
    //singleton Animal instance of Animal are different things
    val canLiveIndefinitly = false
  }
  val animalCanLiveForever = Animal.canLiveIndefinitly //"staic" fields/methods in Java

  /*
  case classes = lightweight data structure with some boilerplate
   compiler will generate:
  - sensible equals and has code
  - serialization
  - companion with apply
   */
  case class Person(name: String, age: Int)
  //can be constructed without keyword new
  val bob = Person("Bob", 43) // Person.apply("Bob", 43)
  //exceptions
  try {
    //code that can throw
    val x: String = null
    x.length
  }catch {
    case e: Exception => "Some faulty message"
  } finally {
    //will execute no matter what
  }
  //generics
  abstract class MyList[T] {
    def head : T
    def tail: MyList[T]
  }
  val aList:  List[Int] = List(1,2,3) //List.apply(1,2,3)
  val first = aList.head
  var rest = aList.tail
  val aStringList = List("Hello", "Scala")
  val firstString = aStringList.head

  // Point #1: in Scala we usually operate with IMMUTABLE value/object
  //any modification to an object must return new object
  /*
  Benefits:
  1) works miravles in multithreading/distributed env
  2) helps making sense of the code ("reasoning about)
   */
  val reversedList = aList.reverse //return a NEW list

}
