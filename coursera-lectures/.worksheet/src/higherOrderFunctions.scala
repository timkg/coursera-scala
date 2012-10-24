object higherOrderFunctions {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(119); 

	def sumIntsBetween(a: Int, b: Int): Int =
		if(a > b) 0 else a + sumIntsBetween(a+1, b);System.out.println("""sumIntsBetween: (a: Int, b: Int)Int""");$skip(22); val res$0 = 
	sumIntsBetween(1, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(38); 

	def cube(x: Int): Int =
		x * x * x;System.out.println("""cube: (x: Int)Int""");$skip(13); val res$1 = 
		
	cube(10);System.out.println("""res1: Int = """ + $show(res$1));$skip(102); 

	def sumCubesInterval(a: Int, b: Int): Int =
		if(a > b) 0 else cube(a) + sumCubesInterval(a + 1, b);System.out.println("""sumCubesInterval: (a: Int, b: Int)Int""");$skip(330); val res$2 = 
	// how can I reason about recursive function construction?
	// for example sumCubesInterval
	// 1..4. We want it to calculate the cube of 1, 2, 3, and 4,
	// and to stop at 5.
	// progression - start with first, then repeat with steps of +1
	// cube(a) + repeatCubeWith(a+1)
	// work in an end condition

	sumCubesInterval(1, 4);System.out.println("""res2: Int = """ + $show(res$2));$skip(39); val res$3 = 
	cube(1) + cube(2) + cube(3) + cube(4);System.out.println("""res3: Int = """ + $show(res$3));$skip(94); 
	
	
	def sum(f: Int => Int, a: Int, b: Int): Int =
		if(a > b) 0 else f(a) + sum(f, a + 1, b);System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(53); 
		
	def sumInts(a: Int, b: Int): Int = sum(id, a, b);System.out.println("""sumInts: (a: Int, b: Int)Int""");$skip(52); 
	def sumCubes(a: Int, b: Int): Int = sum(cub, a, b);System.out.println("""sumCubes: (a: Int, b: Int)Int""");$skip(58); 
	def sumFactorials(a: Int, b: Int): Int = sum(fact, a, b);System.out.println("""sumFactorials: (a: Int, b: Int)Int""");$skip(28); 
	
	def id(x: Int ): Int = x;System.out.println("""id: (x: Int)Int""");$skip(34); 
	def cub(x: Int): Int = x * x * x;System.out.println("""cub: (x: Int)Int""");$skip(59); 
	def fact(x: Int): Int = if(x == 0) 1 else x * fact(x - 1);System.out.println("""fact: (x: Int)Int""");$skip(10); val res$4 = 
 	fact(4);System.out.println("""res4: Int = """ + $show(res$4));$skip(17); val res$5 = 
	
	sumInts(1, 4);System.out.println("""res5: Int = """ + $show(res$5));$skip(16); val res$6 = 
	sumCubes(1, 4);System.out.println("""res6: Int = """ + $show(res$6));$skip(21); val res$7 = 
	sumFactorials(1, 4);System.out.println("""res7: Int = """ + $show(res$7));$skip(478); 
	
	
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
	};System.out.println("""tailRecSum: (f: Int => Int, a: Int, b: Int)Int""");$skip(25); val res$8 = 
	
	tailRecSum(cub, 1, 4);System.out.println("""res8: Int = """ + $show(res$8));$skip(63); val res$9 = 
	// with anonymous function:
	tailRecSum(x => x * x * x, 1, 4);System.out.println("""res9: Int = """ + $show(res$9))}
}