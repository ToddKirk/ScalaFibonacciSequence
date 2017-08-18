package com.kirk

import org.scalatest.{FlatSpec, Matchers}

class FibonacciSequenceTest extends FlatSpec with Matchers {

  it should "returns 0 given a value of 0" in {
    FibonacciSequence.fibonacciSequence(0)
  }

  it should "returns 55 given a value of 10" in {
    FibonacciSequence.fibonacciSequence(10)
  }

  it should "throw ArithmeticException if the value passed in creates a sequence that overflows an Integer" in {
    an[ArithmeticException] should be thrownBy {
      FibonacciSequence.fibonacciSequence(100)
    }
  }
}