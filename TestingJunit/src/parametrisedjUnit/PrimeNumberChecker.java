// https://dzone.com/articles/working-with-junitparams

package parametrisedjUnit;

public class PrimeNumberChecker {

	public PrimeNumberChecker() {
		// TODO Auto-generated constructor stub
	}
	
	public Boolean validatePrime(final Integer primeNumber) {
	      for (int i = 2; i < (primeNumber / 2); i++) {
	         if (primeNumber % i == 0) {
	            return false;
	         }
	      }
	      return true;
	   }
	
	public Boolean validateOdd(final Integer number)
	{
		if (number % 2 == 0) 
            return false;
		return true;
         
	}

}
