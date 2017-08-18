package com.kirk

object FibonacciSequence {
  def fibonacciSequence(i: Int): Int = {

    def go(n: Int, np: Int, c: Int): Int = {
      if (c >= i) n
      else if (n.toLong + np.toLong >= Int.MaxValue) {
        throw new ArithmeticException("Int out of bounds")
      }
      else go(if (c == 0) n + 1 else n + np, n, c + 1)
    }

    go(0, 0, 0)
  }
}
