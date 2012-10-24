object sheet1 {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(90); 
  
  
  def gcd(a: Int, b: Int): Int =
  	if (b == 0) a else gcd(b, a % b);System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(16); val res$0 = 
  
  gcd(7, 14);System.out.println("""res0: Int = """ + $show(res$0));$skip(80); 
  
  
  def factorial(n: Int): Int =
  	if (n == 0) 1 else n * factorial(n - 1);System.out.println("""factorial: (n: Int)Int""");$skip(19); val res$1 = 
  	
  factorial(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(346); 
  
  
  
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
  };System.out.println("""factorial2: (n2: Int)Int""");$skip(19); val res$2 = 
  
  factorial2(5);System.out.println("""res2: Int = """ + $show(res$2))}
		  	
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