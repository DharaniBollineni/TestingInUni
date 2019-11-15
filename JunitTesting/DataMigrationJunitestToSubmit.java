package domParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class DataMigrationJunitestToSubmit extends TestCase {
	DataMigrationProjectToSubmit dm;
	File fXmlFile;
	static ArrayList<PlayersJava> xmlPlayerList = new ArrayList<PlayersJava>();
	static int noOfRecordXML = 0;
	static ArrayList<String> xmlPlayerListString = new ArrayList<String>();
	static ArrayList<String> dbPlayerListString = new ArrayList<String>();
	static ArrayList<Integer> mismatchList = new ArrayList<>();

	@BeforeEach
	// Intialize
	public void intializeObject() {
		System.out.println("Before test");
		dm = new DataMigrationProjectToSubmit();
		try {
			if (dm.validateSchema()) {
				fXmlFile = new File("premierLeaguePlayerNames.xml");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	// // Test to cleanUp before loading details to DB PlayersXml table
	// @Test
	// void testCleanUPTable() {
	// System.out.println("Before test");
	// try {
	// boolean cleanUpstatus= dm.cleanUPTable();
	// assertEquals(true, cleanUpstatus); // actual and expected
	// System.out.println("Pass :: cleanUp table before loading records in the DB
	// players table");
	// } catch (Exception e) {
	// System.out.println("Fail :: cleanUp table before loading records in the DB
	// players table");
	// }
	// }
	//

	// Test the number of roots in the xml file
	@Test
	void testCountNumberOfTablesInXML() {
		try {
			int noOfTables = dm.countNumberOfTablesInXML(fXmlFile);
			assertEquals(1, noOfTables); // actual and expected
			System.out.println("Pass :: the number of roots in the xml file");

		} catch (Exception e) {
			System.out.println("Fail :: the number of roots in the xml file");
		}

	}

	// Test the number of records in the xml file
	@Test
	void testTotalRecordsInXML() {
		try {
			noOfRecordXML = dm.totalRecordsInXML(fXmlFile);
			assertEquals(461, noOfRecordXML); // actual and expected
			System.out.println("Pass :: Test case :: Test the number of records in the xml file");
		} catch (Exception e) {
			System.out.println("Fail :: Test case :: Test the number of records in the xml file");
		}
	}

	// Test whether table is created with primary key or not
	@Test
	void testValidatePrimaryKeyExists() {
		try {
			assertEquals(true, dm.validatePrimaryKeyExists()); // actual and expected
			System.out.println("Pass :: Test case :: Table is created with primary key or not");
		} catch (Exception e) {
			System.out.println("Fail :: Test case :: Table is created with primary key or not");
		}
	}

	// Test whether table is created with 7 columns or not
	@Test
	void testCountNumOfColumns() {
		try {
			assertEquals(7, dm.countNumOfColumns()); // actual and expected
			System.out.println("Pass :: Test case :: Test whether table is created with 7 columns or not");
		} catch (Exception e) {
			System.out.println("Fail :: Test case :: Test whether table is created with 7 columns or not");
		}

	}

	// Test to load all records from xml file to ArrayList
	@Test
	void testLoad() {
		try {
			xmlPlayerList = dm.load();
			assertEquals(461, xmlPlayerList.size()); // actual and expected
			System.out.println("Pass :: load all records from xml file to ArrayList");
		} catch (Exception e) {
			System.out.println("Fail :: load all records from xml file to ArrayList");
		}
	}
	
	// Test to dsiplay records from xml file
	@Test
	void testDisplay()
	{
		try {
			 
			assertEquals(true, dm.displayXml(xmlPlayerList)); // actual and expected
			System.out.println("Pass :: Test to dsiplay records from xml file");
		} catch (Exception e) {
			System.out.println("Fail :: Test to dsiplay records from xml file");
		}
	}

	// Test to load all the records from xml to DB without duplicates
	@Test
	void testWriteToDB() {
		try {
			boolean writeToDBStatus = dm.writeToDB(xmlPlayerList);
			assertEquals(true, writeToDBStatus); // actual and expected
			System.out.println("Pass :: load all the records from xml to DB without duplicates");
		} catch (Exception e) {
			System.out.println("Fail :: load all the records from xml to DB without duplicates ");
		}
	}

	// validate data is migrated with out Unknow And Zero
	@Test
	void testValidateLoadByUnknowAndZero() {
		try {
			assertEquals(false, dm.validateLoadByUnknowAndZero()); // actual and expected
			System.out.println("Pass :: Test case :: Validate data is migrated with out Unknow And Zero");
		} catch (Exception e) {
			System.out.println("Fail :: Test case :: validate data is migrated with out Unknow And Zero");
		}
	}

	// Test to convert ArrayList<PlayersJava> data to ArrayList<String> later used
	// to validate data migration without data truncate
	@Test
	void testGetAsString() {
		boolean status;
		try {
			try {
				xmlPlayerListString = dm.getAsString(xmlPlayerList);
				status = true;

			} catch (Exception e1) {
				status = false;
			}
			assertEquals(true, status); // actual and expected
			System.out.println("Pass :: Convert ArrayList<PlayersJava> data to ArrayList<String>");
		} catch (Exception e) {
			System.out.println("Fail :: Convert ArrayList<PlayersJava> data to ArrayList<String>");
		}
	}

	// Test to convert DB records data to collective string arraylist. Later used to
	// validate data migration without data truncate
	@Test
	void testGetRecordAsString() {
		boolean status;
		try {
			try {
				dbPlayerListString = dm.getRecordAsString();
				status = true;
			} catch (Exception e1) {
				status = false;
			}
			assertEquals(true, status); // actual and expected
			System.out.println("Pass :: convert DB records data to collective string arraylist");
		} catch (Exception e) {
			System.out.println("Fail :: convert DB records data to collective string arraylist");
		}
	}

	// compare & validate data is migrated without any truncates (data maybe data
	// truckated due to data type size)
	// also helpful to test order mismatch
	@Test
	void testIsAnyDataTruncate() {
		boolean status;
		try {
			mismatchList = dm.validateDataTruncate(xmlPlayerListString, dbPlayerListString);
			assertEquals(0, mismatchList.size()); // actual and expected
			System.out.println(
					"Pass :: compare & validate data is migrated without any truncates (data maybe data truckated due to data type size)");
		} catch (Exception e) {
			System.out.println(
					"Fail :: compare & validate data is migrated without any truncates (data maybe data truckated due to data type size)");
		}
	}

	// Check id is unique(Validate there is only one existence of given Id in the
	// table)
	@Test
	void testCountNoOfIDs() {
		try {
			assertEquals(1, dm.countNoOfIDs(10)); // actual and expected
			System.out.println("Pass :: Validate there is only one existence of given Id in the table");
		} catch (Exception e) {
			System.out.println("Fail :: Validate there is only one existence of given Id in the table");
		}
	}

	// compare and test xml arrayList and DB records related to club
	// Check the loaded arraylist has n number of records with the given club which
	// is same as DB count
	@Test
	void testVerifybyClub() {
		try {
			String clubStr = "Watford";
			// from xml file
			ArrayList<PlayersJava> playerByClubxml = dm.verifybyClubXML(xmlPlayerList, clubStr);
			int xmlClubSize = playerByClubxml.size();
			System.out.println("xmlClubSize" + xmlClubSize);

			// from db
			ArrayList<PlayersJava> playerByClubedb = dm.filterByClub("Watford");
			int dbClubSize = playerByClubedb.size();
			System.out.println("dbClubSize" + dbClubSize);

			assertEquals(xmlClubSize, dbClubSize); // actual and expected
			System.out.println(
					"Pass :: Check the loaded arraylist has n number of records with the given club and its same with DB count");
		} catch (Exception e) {
			System.out.println(
					"Fail :: Check the loaded arraylist has n number of records with the given club and its same with DB count");
		}
	}

	// compare and test xml arrayList and DB records related to nationality
	// Check the loaded arraylist has n number of records with the given nationality
	// which
	// is same as DB count
	@Test
	void testVerifybyNationality() {
		try {

			String nationalityStr = "England";
			// from xml file
			ArrayList<PlayersJava> playerBynNationalityxml = dm.verifybyNationalityXML(xmlPlayerList, nationalityStr);
			int xmlNationalitySize = playerBynNationalityxml.size();
			System.out.println("xmlNationalitySize" + xmlNationalitySize);

			// from db
			ArrayList<PlayersJava> playerByNationalitydb = dm.filterByNationality(nationalityStr);
			int dbNationalitySize = playerByNationalitydb.size();
			System.out.println("dbNationalitySize" + dbNationalitySize);

			assertEquals(xmlNationalitySize, dbNationalitySize); // actual and expected
			System.out.println(
					"Pass :: Check the loaded arraylist has n number of records with the given Nationality and its same with DB count");
		} catch (Exception e) {
			System.out.println(
					"Fail :: Check the loaded arraylist has n number of records with the given Nationality and its same with DB count");
		}
	}

	// compare and test xml arrayList and DB records related to name
	// Check the loaded arraylist has n number of records with the given name which is same as DB count@Test
	void testVerifybyName() {
		try {

			String nameStr = "Michail Antonio";
			// from xml file
			ArrayList<PlayersJava> playerBynNamexml = dm.verifybyNationalityXML(xmlPlayerList, nameStr);
			int xmlNameSize = playerBynNamexml.size();
			System.out.println("xmlNameSize" + xmlNameSize);

			// from db
			ArrayList<PlayersJava> playerByNamedb = dm.filterByNationality(nameStr);
			int dbNameSize = playerByNamedb.size();
			System.out.println("dbNameSize" + dbNameSize);

			assertEquals(xmlNameSize, dbNameSize); // actual and expected
			System.out.println(
					"Pass :: Check the loaded arraylist has n number of records with the given name and its same with DB count");
		} catch (Exception e) {
			System.out.println(
					"Fail :: Check the loaded arraylist has n number of records with the given name and its same with DB count");
		}
	}
	
}
