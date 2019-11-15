package domParser;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class SampleTest extends TestCase {
	
	public SampleTest() {
		
	}

	@BeforeAll
	protected void setUp() throws Exception {
		System.out.println("Setup is called...");
		super.setUp();
	}

	@AfterAll
	protected void tearDown() throws Exception {
		System.out.println("Teardown is called...");
		super.tearDown();
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	

	@Test
	void test1() {
		fail("Not yet implemented");
	}

}
