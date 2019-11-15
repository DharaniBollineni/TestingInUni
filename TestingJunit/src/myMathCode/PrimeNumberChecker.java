package myMathCode;

// class to test
public class PrimeNumberChecker {

	public static boolean isPrime(int n) {
		// Corner case
		if (n <= 1)
			return false;
		// Check from 2 to n-1
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;
		return true;
	}	
	public Boolean validateOdd(final Integer number)
	{
		if (number % 2 == 0) 
            return false;
		return true;         
	}
}
