object higherOrderFunctions {

	def sumIntsBetween(a: Int, b: Int): Int =
		if(a > b) 0 else a + sumIntsBetween(a+1, b)
                                                  //> sumIntsBetween: (a: Int, b: Int)Int
	sumIntsBetween(1, 4)                      //> res0: Int = 10


	def cube(x: Int): Int =
		x * x * x                         //> cube: (x: Int)Int
		
	cube(10)                                  //> res1: Int = 1000

	def sumCubesInterval(a: Int, b: Int): Int =
		if(a > b) 0 else cube(a) + sumCubesInterval(a + 1, b)
                                                  //> sumCubesInterval: (a: Int, b: Int)Int
	// how can I reason about recursive function construction?
	// for example sumCubesInterval
	// 1..4. We want it to calculate the cube of 1, 2, 3, and 4,
	// and to stop at 5.
	// progression - start with first, then repeat with steps of +1
	// cube(a) + repeatCubeWith(a+1)
	// work in an end condition

	sumCubesInterval(1, 4)                    //> res2: Int = 100
	cube(1) + cube(2) + cube(3) + cube(4)     //> res3: Int = 100
	
	
	def sum(f: Int => Int, a: Int, b: Int): Int =
		if(a > b) 0 else f(a) + sum(f, a + 1, b)
                                                  //> sum: (f: Int => Int, a: Int, b: Int)Int
		
	def sumInts(a: Int, b: Int): Int = sum(id, a, b)
                                                  //> sumInts: (a: Int, b: Int)Int
	def sumCubes(a: Int, b: Int): Int = sum(cub, a, b)
                                                  //> sumCubes: (a: Int, b: Int)Int
	def sumFactorials(a: Int, b: Int): Int = sum(fact, a, b)
                                                  //> sumFactorials: (a: Int, b: Int)Int
	
	def id(x: Int ): Int = x                  //> id: (x: Int)Int
	def cub(x: Int): Int = x * x * x          //> cub: (x: Int)Int
	def fact(x: Int): Int = if(x == 0) 1 else x * fact(x - 1)
                                                  //> fact: (x: Int)Int
 	fact(4)                                   //> res4: Int = 24
	
	sumInts(1, 4)                             //> res5: Int = 10
	sumCubes(1, 4)                            //> res6: Int = 100
	sumFactorials(1, 4)                       //> res7: Int = 33
	
	
	// tail-recursive version of sum
	
	def tailRecSum(f: Int => Int, a: Int, b: Int): Int = {
		def loop(a: Int, acc: Int): Int = {
			// each iteration, we want to compute f()
			//  for the current value of a and keep
			// adding it to a "temporary variable",
			// and then increase our counter for
			// the next iteration
			// when we reach the end, we return the value
			// of our "temporary variable"
			if(a > b) acc  else loop(a+1, f(a) + acc)
		}
		loop(a, 0)
	}                                         //> tailRecSum: (f: Int => Int, a: Int, b: Int)Int
	
	tailRecSum(cub, 1, 4)                     //> res8: Int = 100
	// with anonymous function:
	tailRecSum(x => x * x * x, 1, 4)          //> res9: Int = 100
}