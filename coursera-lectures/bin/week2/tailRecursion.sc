object sheet1 {
  
  
  def gcd(a: Int, b: Int): Int =
  	if (b == 0) a else gcd(b, a % b)          //> gcd: (a: Int, b: Int)Int
  
  gcd(7, 14)                                      //> res0: Int = 7
  
  
  def factorial(n: Int): Int =
  	if (n == 0) 1 else n * factorial(n - 1)   //> factorial: (n: Int)Int
  	
  factorial(5)                                    //> res1: Int = 120
  
  
  
  // tail-recursice
  // all this shifting around of stuff is
  // done so that the last operation is
  // a simple function call, without any
  // other operations
  def factorial2(n2: Int): Int = {
  	def factorialStep(acc: Int, n2: Int): Int =
  		if (n2 == 0) acc
  		else factorialStep(acc * n2, n2 - 1)
  	factorialStep(1, n2)
  }                                               //> factorial2: (n2: Int)Int
  
  factorial2(5)                                   //> res2: Int = 120
		  	
	// the arguments to factorialStep,
	// acc * n2, n2 - 1,
	// basically serve as loop conditions and
	// temporary value store.
	// Since that function is called recursively,
	// and arguments are evaluated to values,
	// when the condition
	// if (n2 == 0)
	// is met, acc holds the correct value
	// and we return it. There is no need
	// to store anywhere the value of acc,
	// it is evaluated and returned.
  
}