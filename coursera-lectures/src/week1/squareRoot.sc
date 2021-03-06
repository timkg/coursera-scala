object squareRoot {

  def sqrt(x: Double) = {

    def abs(x: Double) = if (x < 0) -x else x

    def sqrtIteration(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIteration(improve(guess))
      
    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIteration(1.0)
  }                                               //> sqrt: (x: Double)Double
  
  sqrt(1.0e-20)                                   //> res0: Double = 1.0000021484861236E-10

}

/*
we can define an iteration through recursive functions by defining an inner iteration function
that checks for an end condition. If met, it returns the value. If not, it calls itself again.
*/