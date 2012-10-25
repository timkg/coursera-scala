object currying {
  
  // review our sum functions from last lecture:
  
  def sumInts(a: Int, b: Int) = sum(x => x, a, b) //> sumInts: (a: Int, b: Int)Int
  def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
                                                  //> sumCubes: (a: Int, b: Int)Int
  // important part is f(a) + sum(f, a + 1, b)
  // this basically states:
  // "perform operation and sum continously
  // with progressively larger input"
  def sum(f: Int => Int, a: Int, b: Int): Int =
		if(a > b) 0 else f(a) + sum(f, a + 1, b)
                                                  //> sum: (f: Int => Int, a: Int, b: Int)Int
  sumInts(1, 4)                                   //> res0: Int = 10
  sumCubes(1, 4)                                  //> res1: Int = 100
  
	// We could create another function which manages
	// input progression. Reminds me of the
	// "improveGuess" function from the sqrt example
	
	def sum2(f: Int => Int, a: Int, b: Int): Int = {
		def progressInput(x: Int): Int = {
			a + 1
		}
		if(a > b) 0 else f(a) + sum(f, progressInput(a), b)
	}                                         //> sum2: (f: Int => Int, a: Int, b: Int)Int
	def sumInts2(a: Int, b: Int) = sum2(x => x, a, b)
                                                  //> sumInts2: (a: Int, b: Int)Int
	def sumCubes2(a: Int, b: Int) = sum2(x => x * x * x, a, b)
                                                  //> sumCubes2: (a: Int, b: Int)Int
	sumInts2(1, 4)                            //> res2: Int = 10
	sumCubes2(1, 4)                           //> res3: Int = 100
		
		
	// done with the review
	
	// we want to continue "combining" functions,
	// but without the need to define them all
	// seperately.
	
	// we need a function that returns a function
	
	// function return type: (Int, Int) => Int
	def sum3(f: Int => Int): (Int, Int) => Int = {
		// define an inner function that applies
		// a function passed as argument to the other
		// argumnets
		def sumF(a: Int, b: Int): Int =
			// our usual suspect: perform operation
			// and sum to continuous operation with
			// increasing input until end
			// condition is met
			if(a > b) 0 else f(a) + sumF(a + 1, b)
		// in the end, return the inner function
		sumF
	}                                         //> sum3: (f: Int => Int)(Int, Int) => Int
	
	// call it with double argument groups
	// first the function, then the arguments
	// to be applied to the returned function
	
	sum3(x => x)(1, 4)                        //> res4: Int = 10
	sum3(x => x * x * x)(1, 4)                //> res5: Int = 100
	
	// instead of calling right away with the 2nd
	// group of arguments, we can just define the functions
	
	def sumInts3 = sum3(x => x)               //> sumInts3: => (Int, Int) => Int
	def sumCubes3 = sum3(x => x * x * x)      //> sumCubes3: => (Int, Int) => Int
	
	sumInts3(1, 4)                            //> res6: Int = 10
	sumCubes3(1, 4)                           //> res7: Int = 100

	// we can write this even shorter, using a
	// special syntax:

	def sum4(f: Int => Int)(a: Int, b: Int): Int =
		if (a > b) 0 else f(a) + sum4(f)(a + 1, b)
                                                  //> sum4: (f: Int => Int)(a: Int, b: Int)Int
		
	sum4(x => x * x * x)(1, 4)                //> res8: Int = 100

	// exercise
	// - write product function that calculates product
	// of values of a function for points on a given interval
	def product(f: Int => Int)(a: Int, b: Int): Int =
		// the unit value of product is 1 (anything * 1 = anything)
		// when a>b, we want nothing to happen, so we multiply by 1
		// instead of 0
		if(a > b) 1 else f(a) * product(f)(a + 1, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x => x * x)(3, 4)                       //> res9: Int = 144
	// - write factorial in terms of product
	
	// my wrong 1st solution
	// this would calculate constantly the factorial for each
	// iteration, instead of the factorial of the first
	def factWrong(a: Int): Int =
		product(factWrong)(1, a)          //> factWrong: (a: Int)Int
		
	def fact(a: Int): Int = product(x => x)(1, a)
                                                  //> fact: (a: Int)Int
	fact(5)                                   //> res10: Int = 120

	// - write more general function which generalizes both
	// sum and product. We need to specify the unit value -
	// what to do when we want to do nothing (boy, that sounds
	// deep), and the type of mapping 
	
	


}