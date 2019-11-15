package mycodeTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;


import myMathCode.MyMathUtil;

class mytest {
	
	MyMathUtil mMath = new MyMathUtil();
	
	@Test
	void testAdd() {
		try {
			// fail("Not yet implemented");
			int value = mMath.add(2, 5);
			assertEquals(7, value); // actual and expected
			System.out.println("test1");
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		}
	}

	@Test
	void testSub() {
		try {
			int value = mMath.sub(2, 5);
			assertEquals(7, value); // actual and expected
			System.out.println("test2");
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		}
	}

	@Test
	void testMult() {
		try {
			int value = mMath.mult(2, 5);
			assertEquals(7, value); // actual and expected
			System.out.println("test3");
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		}
	}

	@Test
	void testAdd1() {
		int sizelimit = 50;
		try {
			for (int i = 0; i < sizelimit; i++) {
				for (int j = 0; j < sizelimit; j++) {
					assertEquals(i + j, mMath.add(i, j));// actual and expected
				}
			}
			System.out.println("test4");
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		}
	}
	
	@Test
	void testPrime()
	{
		try {			
			assertEquals(true,mMath.isPrime(104729)); 	
			System.out.println("test5");
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		}
	}
	
	@Test
	void testPrimeWithLoop()
	{
		try {
			for (int i = 0; i < 50; i++) {
			assertEquals(true,mMath.isPrime(11)); 				
			}
			System.out.println("test6");
			
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		}
	}
	
	@Test
	void testWindowWordCount() {
		
		try {
			String inputStr="Hello";			
			int countWindows;
			int countWordCount;
			//String fileList="testInputword.txt";
			String[] fileList={"alice29.txt","testInputword.txt","testout.txt"};
			for (int i = 0; i < fileList.length; i++) {
				countWindows=mMath.ToCountMethodCmd(fileList[i], inputStr);
				countWordCount=mMath.countMethod(fileList[i], inputStr);
				try {
			    assertEquals(countWordCount,countWindows); 		
				}catch (Exception e) {
					System.out.println("Not same");
				}				
			}			
			System.out.println("test8");
			
		} catch (Exception e) {
			System.out.println("Not same");
		}
		
	}
	
	
//	@Test
//	void wordCountTest()
//	{
//		try {
//			
//			ToCountMethodCmd (,"the");
//			assertEquals("the",mMath.isPrime(11)); 	
//			
//			
//		} catch (Exception e) {
//			System.out.println("Something went wrong.");
//		}
//	}
}
