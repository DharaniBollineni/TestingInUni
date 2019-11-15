

package parametrisedjUnit;


import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;


//@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest {
   
	//@Parameterized.Parameter(0)
	public Integer inputNumber;
	
	//@Parameterized.Parameter(1)
	public Boolean expectedResult;
   
   private PrimeNumberChecker primeNumberChecker;
   // @Before: @Before annotation are executed before each test. This is useful when we want to execute some common code before running a test.
   // @BeforeEach: @BeforeEach and @BeforeAll are the JUnit 5 equivalents of @Before and @BeforeClass. These annotations were renamed with clearer names to avoid confusion.
   //
   @BeforeEach
   public void initialize() {
	  System.out.println("initialize");
      primeNumberChecker = new PrimeNumberChecker();
   }

   // Each parameter should be placed as an argument here
   // Every time runner triggers, it will pass the arguments
   // from parameters we defined in primeNumbers() method
	
//   public PrimeNumberCheckerTest(Integer inputNumber, Boolean expectedResult) {
//	   System.out.println("Constructor");
//      this.inputNumber = inputNumber;
//      this.expectedResult = expectedResult;
//   }
   
   @Parameters (name = "{index}: validatePrime({0})= {1}")//lable to tell which testcase is failling
   public static Collection primeNumbers() {
	   System.out.println("Generate Prime testCases");
      return Arrays.asList(new Object[][] {
         { 2, true },
         { 6, false },
         { 19, true },
         { 22, false },
         { 23, true }
      });
   }

   @Parameters (name = "{index}: validateOdd({0})= {1}")
   public static Collection oddNumbers() {
	  System.out.println("Generate Odd testCases");
      return Arrays.asList(new Object[][] {
         { 1, true },
         { 3, true },
         { 22, false },
         { 45, false },
         { 28, false }
      });
   }
   //This test will run n times depending on the size of the parameters
   //Parameterized tests are like other tests except that we add the @ParameterizedTest annotation:
   //The name we supply to @MethodSource needs to match an existing method. JUnit will search for a source method with the same name as the test method.
   //it assigns a different value from the @ValueSource array to the number method parameter.
   @ParameterizedTest  
   @MethodSource("primeNumbers")
   public void testPrimeNumberChecker(int inputNumber, boolean expectedResult) {
      System.out.println("Parameterized Number is : " + inputNumber);
      assertEquals(expectedResult, primeNumberChecker.validatePrime(inputNumber));
   }   
   // This test will run n times depending on the size of the parameters
   @ParameterizedTest
   @MethodSource("oddNumbers")// 
   public void testoDDNumberChecker(int inputNumber, boolean expectedResult) {     
	  System.out.println("Parameterized Number is : " + inputNumber);
      assertEquals(expectedResult, primeNumberChecker.validatePrime(inputNumber));
   }
}


//https://www.baeldung.com/parameterized-tests-junit-5
