package mycodeTesting;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import myMathCode.PrimeNumberChecker;
/* When a class is annotated with @RunWith or extends a class annotatedwith @RunWith, 
 * JUnit will invoke the class it references to run thetests in that class instead of the runner
 *  built into JUnit. We added this feature latein development. While it seems powerful we 
 *  expect the runner API to change as we learnhow people really use it. Some of the classes 
 *  that are currently internal will likelybe refined and become public.For example, suites in 
 *  JUnit 4 are built using RunWith, and a custom runner named Suite: 
 @RunWith(Suite.class)
 @SuiteClasses({ATest.class, BTest.class, CTest.class})
 public class ABCSuite {
 }

*/

@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest {
	private Integer inputNumber;
	private Boolean expectedResult;
	private PrimeNumberChecker primeNumberChecker;

	
	/*
	 * When writing tests, it is common to find that several tests need
	 * similarobjects created before they can run. Annotating a public void
	 * methodwith @Before causes that method to be run before the Test
	 * method.The @Before methods of superclasses will be run before those of the
	 * current class,unless they are overridden in the current class. No other
	 * ordering is defined. 
	 * Here is a simple example: public class Example { List empty; 
	 * @Before public void initialize() { empty= new ArrayList(); } 
	 * @Test public void size() { ... }
	 * @Test public void remove() { ... } }
	 */
	@Before // anotation before start of the program
	public void initialize() {
		System.out.println("initialize");
		primeNumberChecker = new PrimeNumberChecker();
	}

	public PrimeNumberCheckerTest(Integer inputNumber, Boolean expectedResult) {
		System.out.println("Construtor");
		this.inputNumber = inputNumber;
		this.expectedResult = expectedResult;
	}
	
	//The custom runner Parameterized implements parameterized tests.When running a 
	//parameterized test class, instances are created for thecross-product of the test methods 
	//and the test data elements. 
	@Parameterized.Parameters 
	public static Collection primeNumbers() {
		System.out.println("generate testcase");
		return Arrays.asList(new Object[][] 
				{ { 2, true }, { 6, false }, { 19, true }, { 22, false }, { 20, false },{ 19, true } });
	}
	
	@Test // test case
	public void testPrimeNumberChecker()
	{
		System.out.println("Parameterized Number is "+inputNumber);
	assertEquals(expectedResult, primeNumberChecker.isPrime(inputNumber));
	}
	
	

}
