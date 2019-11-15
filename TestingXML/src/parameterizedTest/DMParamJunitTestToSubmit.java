package parameterizedTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized.Parameters;

class DMParamJunitTestToSubmit {

	private DMParameterizeUtilityToSubmit dpm;
	public Boolean expectedResult;
	private static ArrayList<PlayersJava> xmlPlayerList;

	//Executes the test before every test
	//Initialize and load xml details to arraylist and DB before each test case with out duplicates.
	@BeforeEach
	public void initialize() {
		System.out.println("initialize");
		dpm = new DMParameterizeUtilityToSubmit();
		try {
			xmlPlayerList = dpm.load();
		} catch (Exception e) {
			System.out.println("Unable to load to Arraylist");
			System.exit(0);
		}
		try {
			boolean writeToDBStatus = dpm.writeToDB(xmlPlayerList);
			System.out.println("Successfull load to DB");
		} catch (Exception e) {
			System.out.println("Unable to load to DB");
			System.exit(0);
		}

	}

	// clean up DB after every test execution
	@AfterEach
	public void cleanUpDB() {
		boolean cleanUpstatus = dpm.cleanUPTable();
		if (cleanUpstatus) {
			System.out.println("successfully");
		} else {
			System.out.println("have an issue with cleanup");
		}
	}
	
	
	// Collection of name inputs and expected results for parameterized used for @MethodSource
	@Parameters(name = "{index}: verifybyNameXML({0})= {1}") // lable to tell which testcase is failling
	public static Collection byNameXml() {
		System.out.println("Validate By Name Xml testCases");
		return Arrays.asList(new Object[][] { { "Jake Livermore", 1 }, { "Mousa Dembele", 1 }, { "Harry Kane", 1 }, { "Erik Lamela", 1 },{ "unknown", 0 } });
	}
	
	// Collection of Age inputs and expected results for parameterized used for @MethodSource
	@Parameters(name = "{index}: verifybyAgeXML({0})= {1}")
	public static Collection byAgeXml() {
		System.out.println("Validate By Age Xml testCases");
		return Arrays.asList(new Object[][] { { 29, 30 }, { 30, 35 }, { 35, 6 }, { 24, 33 }, { 0, 0 } });
	}
	// Collection of club inputs and expected results for parameterized used for @MethodSource
	@Parameters(name = "{index}: verifybyClubXML({0})= {1}")
	public static Collection byClubXml() {
		System.out.println("Validate By Club Xml testCases");
		return Arrays.asList(new Object[][] { { "Watford", 24 }, { "Huddersfield", 28 }, { "Swansea", 25 }, { "Tottenham", 20 }, { "Liverpool", 27 },{ "unknown", 0 } });
	}
	// Collection of nationality inputs and expected results for parameterized used for @MethodSource
	@Parameters(name = "{index}: verifybyNationalityXML({0})= {1}")
	public static Collection byNationalityXml() {
		System.out.println("Validate By Nationality Xml testCases");
		return Arrays.asList(new Object[][] { { "Germany", 16 }, { "France", 25 }, { "Spain", 28 }, { "England", 156 }, { "Italy", 4 },{ "unknown", 0 } });
	}
	// Parameterized test with byNameXml input and expected results(This test will run n times depending on the size of the parameters)
	@ParameterizedTest
	@MethodSource("byNameXml")
	public void testValidatebyNameXml(String inputName, int expectedResult) {
		System.out.println("Parameterized Name is : " + inputName);
		System.out.println("\n"+dpm.verifyByNameXML(xmlPlayerList,inputName));
		assertEquals(expectedResult, dpm.verifyByNameXML(xmlPlayerList,inputName));
	}

	// Parameterized test with byNameXml input and expected results (This test will run n times depending on the size of the parameters)
	@ParameterizedTest
	@MethodSource("byAgeXml") //
	public void testValidatebyAgeXml(int inputage, int expectedResult) {
		System.out.println("Parameterized Number is : " + inputage);
	assertEquals(expectedResult, dpm.verifybyAgeXML(xmlPlayerList,inputage));
	}
	
	// Parameterized test with byNameXml input and expected results (This test will run n times depending on the size of the parameters)
	@ParameterizedTest
	@MethodSource("byClubXml")
	public void testValidatebyClubXmlr(String inputClub, int expectedResult) {
		System.out.println("Parameterized Club is : " + inputClub);
		assertEquals(expectedResult, dpm.verifybyClubXML(xmlPlayerList,inputClub));
	}

	// Parameterized test with byNationalityXml input and expected results (This test will run n times depending on the size of the parameters)
	@ParameterizedTest
	@MethodSource("byNationalityXml") //
	public void testValidateByNationalityXml(String inputNationality, int expectedResult) {
		System.out.println("Parameterized Nationality is : " + inputNationality);
		 assertEquals(expectedResult, dpm.verifybyNationalityXML(xmlPlayerList,inputNationality));
	}
	
	// This test will run n times depending on the number of elements in @ValueSource
	@ParameterizedTest(name = "{index}: verifybyNameXML({0})= {1}")
	    @ValueSource(strings = { "Jake Livermore", "Mousa Dembele", "Harry Kane","Erik Lamela" })
	    void testByNameDB(String str) {
		 ArrayList<PlayersJava> dbPlayerListName=dpm.filterByName(str);
		 	assertEquals(1, dbPlayerListName.size());
	    }
	 
	// This test will run n times depending on the number of elements in @CsvSource
	 @ParameterizedTest(name = "{index}: verifybyNameXML({0})= {1}")
	 @CsvSource({ "Germany, 16", "France, 25", "Spain, 28","England, 156","unknown, 0" })
	    void testByNationalityDB(String str, int expected) {
				 	assertEquals(expected, dpm.filterByNationality(str));
	    }
	
	// This test will run n times depending on the number of elements in @CsvSource
	 @ParameterizedTest(name = "{index}: verifybyNameXML({0})= {1}")
	 @CsvSource({ "Watford, 24","Huddersfield, 28","Swansea, 25","Tottenham, 20","Liverpool, 27","unknown, 0" })
	    void testByClubDB(String str, int expected) {
			assertEquals(expected, dpm.filterByClub(str));
	    }

}
