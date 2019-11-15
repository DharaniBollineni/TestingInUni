package mycodeTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

class MyParamTest {
	public static void main(String[] arg) {
		Result result=JUnitCore.runClasses(PrimeNumberCheckerTest.class);		
		for(Failure failure: result.getFailures()) {
			System.out.println(failure.toString());
		}		
		System.out.println(result.wasSuccessful());		
//		Result result1=JUnitCore.runClasses(PrimeNumberCheckerTest.class);
//		
//		for(Failure failure: result1.getFailures()) {
//			System.out.println(failure.toString());
//		}
//		
//		System.out.println(result1.wasSuccessful());
//		
	}



}
