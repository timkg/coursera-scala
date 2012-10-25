object currying {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(122); 
  
  // review our sum functions from last lecture:
  
  def sumInts(a: Int, b: Int) = sum(x => x, a, b);System.out.println("""sumInts: (a: Int, b: Int)Int""");$skip(59); 
  def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b);System.out.println("""sumCubes: (a: Int, b: Int)Int""");$skip(248); 
  // important part is f(a) + sum(f, a + 1, b)
  // this basically states:
  // "perform operation and sum continously
  // with progressively larger input"
  def sum(f: Int => Int, a: Int, b: Int): Int =
		if(a > b) 0 else f(a) + sum(f, a + 1, b);System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(16); val res$0 = 
  sumInts(1, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(17); val res$1 = 
  sumCubes(1, 4);System.out.println("""res1: Int = """ + $show(res$1));$skip(304); 
  
	// We could create another function which manages
	// input progression. Reminds me of the
	// "improveGuess" function from the sqrt example
	
	def sum2(f: Int => Int, a: Int, b: Int): Int = {
		def progressInput(x: Int): Int = {
			a + 1
		}
		if(a > b) 0 else f(a) + sum(f, progressInput(a), b)
	};System.out.println("""sum2: (f: Int => Int, a: Int, b: Int)Int""");$skip(51); 
	def sumInts2(a: Int, b: Int) = sum2(x => x, a, b);System.out.println("""sumInts2: (a: Int, b: Int)Int""");$skip(60); 
	def sumCubes2(a: Int, b: Int) = sum2(x => x * x * x, a, b);System.out.println("""sumCubes2: (a: Int, b: Int)Int""");$skip(16); val res$2 = 
	sumInts2(1, 4);System.out.println("""res2: Int = """ + $show(res$2));$skip(17); val res$3 = 
	sumCubes2(1, 4);System.out.println("""res3: Int = """ + $show(res$3));$skip(660); 
		
		
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
	};System.out.println("""sum3: (f: Int => Int)(Int, Int) => Int""");$skip(150); val res$4 = 
	
	// call it with double argument groups
	// first the function, then the arguments
	// to be applied to the returned function
	
	sum3(x => x)(1, 4);System.out.println("""res4: Int = """ + $show(res$4));$skip(28); val res$5 = 
	sum3(x => x * x * x)(1, 4);System.out.println("""res5: Int = """ + $show(res$5));$skip(137); 
	
	// instead of calling right away with the 2nd
	// group of arguments, we can just define the functions
	
	def sumInts3 = sum3(x => x);System.out.println("""sumInts3: => (Int, Int) => Int""");$skip(38); 
	def sumCubes3 = sum3(x => x * x * x);System.out.println("""sumCubes3: => (Int, Int) => Int""");$skip(18); val res$6 = 
	
	sumInts3(1, 4);System.out.println("""res6: Int = """ + $show(res$6));$skip(17); val res$7 = 
	sumCubes3(1, 4);System.out.println("""res7: Int = """ + $show(res$7));$skip(159); 

	// we can write this even shorter, using a
	// special syntax:

	def sum4(f: Int => Int)(a: Int, b: Int): Int =
		if (a > b) 0 else f(a) + sum4(f)(a + 1, b);System.out.println("""sum4: (f: Int => Int)(a: Int, b: Int)Int""");$skip(31); val res$8 = 
		
	sum4(x => x * x * x)(1, 4);System.out.println("""res8: Int = """ + $show(res$8));$skip(366); 

	// exercise
	// - write product function that calculates product
	// of values of a function for points on a given interval
	def product(f: Int => Int)(a: Int, b: Int): Int =
		// the unit value of product is 1 (anything * 1 = anything)
		// when a>b, we want nothing to happen, so we multiply by 1
		// instead of 0
		if(a > b) 1 else f(a) * product(f)(a + 1, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(28); val res$9 = 
  product(x => x * x)(3, 4);System.out.println("""res9: Int = """ + $show(res$9));$skip(239); 
	// - write factorial in terms of product
	
	// my wrong 1st solution
	// this would calculate constantly the factorial for each
	// iteration, instead of the factorial of the first
	def factWrong(a: Int): Int =
		product(factWrong)(1, a);System.out.println("""factWrong: (a: Int)Int""");$skip(50); 
		
	def fact(a: Int): Int = product(x => x)(1, a);System.out.println("""fact: (a: Int)Int""");$skip(9); val res$10 = 
	fact(5);System.out.println("""res10: Int = """ + $show(res$10))}

	// - write more general function which generalizes both
	// sum and product. We need to specify the unit value -
	// what to do when we want to do nothing (boy, that sounds
	// deep), and the type of mapping
	
	


}