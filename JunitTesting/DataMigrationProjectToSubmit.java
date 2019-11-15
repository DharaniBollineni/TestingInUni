package domParser;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DataMigrationProjectToSubmit {
	static int dupli = 0;
	// ***************************************************************************/
	// DataMigrationXML //
	// **************************************************************************//

	private ArrayList<PlayersJava> xmlPlayerList;

	// get Node List object of xml file
	public NodeList getNodeList(File fXmlFile) throws ParserConfigurationException, SAXException, IOException {
		NodeList nList = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			nList = doc.getElementsByTagName("row");
			return nList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nList;
	}

	// Created a xsd file and copied to eclips. Validated the same with xml file.
	public boolean validateSchema() throws MalformedURLException {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File("premierLeaguePlayerNames.xsd"));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File("premierLeaguePlayerNames.xml")));
			System.out.println("schema is validated successfully.. so good to use xml file");
		} catch (IOException | SAXException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
		return true;
	}

	// Count number of tables /roots in the xml file
	public int countNumberOfTablesInXML(File fXmlFile) {
		NodeList nList = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			nList = doc.getElementsByTagName("root");
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return nList.getLength();
	}

	// Count the number of records in the xml file
	public int totalRecordsInXML(File fXmlFile) throws ParserConfigurationException, SAXException, IOException {
		NodeList nList = getNodeList(fXmlFile);
		int count = nList.getLength();
		return count;
	}

	// Load xml player details to ArrayList
	public ArrayList<PlayersJava> load() {
		// Allow the user to specify the XML file. Please use
		// premierLeaguePlayerNames.xml we have seen before. (Core)
		// Parse the XML file to display the players’ data. (Core)
		try {
			xmlPlayerList = new ArrayList<PlayersJava>();
			File fXmlFile = new File("premierLeaguePlayerNames.xml");
			NodeList nList = getNodeList(fXmlFile);

			for (int i = 0; i < nList.getLength(); i++) {
				Node n = nList.item(i);
				Element e = (Element) n;
				String name = null;
				int age = 0;
				String club = null;
				String position = null;
				double marketValue = 0.0;
				String nationality = null;

				try {
					name = e.getElementsByTagName("name").item(0).getTextContent();
				} catch (Exception e1) {
					// System.out.println("Error because of name");
					name = "unknown";
				}

				try {
					age = Integer.parseInt(e.getElementsByTagName("age").item(0).getTextContent());
				} catch (Exception e1) {
					// System.out.println("Error because of name");
					age = 0;
				}
				// int age =
				// Integer.valueOf(e.getElementsByTagName("age").item(0).getTextContent());
				try {
					club = e.getElementsByTagName("club").item(0).getTextContent();
				} catch (Exception e1) {
					// System.out.println("Error because of name");
					club = "unknown";
				}
				try {
					position = e.getElementsByTagName("position").item(0).getTextContent();
				} catch (Exception e1) {
					// System.out.println("Error because of name");
					position = "unknown";
				}

				try {
					marketValue = Double.parseDouble(e.getElementsByTagName("market_value").item(0).getTextContent());
				} catch (Exception e1) {
					// System.out.println("Error because of name");
					marketValue = 0.0;
				}

				try {
					nationality = e.getElementsByTagName("nationality").item(0).getTextContent();
				} catch (Exception e1) {
					// System.out.println("Error because of name");
					nationality = "unknown";
				}
				PlayersJava p = new PlayersJava(name, club, position, marketValue, nationality, age);
				xmlPlayerList.add(p);
			}

			System.out.println("Loaded arrayList Size is: " + xmlPlayerList.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlPlayerList;

	}

	// display Arraylist details of xml records
	public boolean displayXml(ArrayList<PlayersJava> xmlPlayerList) {
		try {
			for (PlayersJava p : xmlPlayerList) {
				System.out.println(p);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// store data of players arraylist to string type arraylist used for comparision
	// / test the data stored without truncate
	public ArrayList<String> getAsString(ArrayList<PlayersJava> playerList) {
		ArrayList<String> strList = new ArrayList<String>();
		for (PlayersJava p : playerList) {
			String str = p.getName() + p.getAge() + p.getClub() + p.getPosition() + p.getMarketValue()
					+ p.getNationality();
			strList.add(str);
		}
		return strList;
	}

	// Count records by age in xml
	public ArrayList<PlayersJava> verifybyAgeXML(ArrayList<PlayersJava> playerList, int sAge) {
		ArrayList<PlayersJava> playerByAge = new ArrayList<>();
		try {
			for (PlayersJava p : playerList) {
				if (sAge == p.getAge()) {
					playerByAge.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return playerByAge;

	}

	// Count records by club in xml
	public ArrayList<PlayersJava> verifybyClubXML(ArrayList<PlayersJava> playerList, String club) {
		ArrayList<PlayersJava> playerByClub = new ArrayList<>();
		try {
			for (PlayersJava p : playerList) {
				if (club.equalsIgnoreCase(p.getClub())) {
					playerByClub.add(p);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return playerByClub;

	}

	// Count records nationality in xml
	public ArrayList<PlayersJava> verifybyNationalityXML(ArrayList<PlayersJava> playerList, String sNationality) {
		ArrayList<PlayersJava> playerByNationality = new ArrayList<>();
		try {

			for (PlayersJava p : playerList) {
				if (sNationality.equalsIgnoreCase(p.getNationality())) {
					playerByNationality.add(p);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return playerByNationality;

	}

	// count records by name in xml
	public ArrayList<PlayersJava> verifyByNameXML(ArrayList<PlayersJava> playerList, String sName) {
		ArrayList<PlayersJava> playerByName = new ArrayList<>();
		try {

			for (PlayersJava p : playerList) {
				if (sName.equalsIgnoreCase(p.getName())) {
					playerByName.add(p);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return playerByName;

	}

	// ***************************************************************************/
	// DataMigrationDB //
	// **************************************************************************//

	// method to connect
	public Connection connectToDB() {
		Connection con = null;
		try {
			String dbUser = "myuser";
			String usrPass = "mypass";
			Class.forName("org.mariadb.jdbc.Driver"); // STEP 2: Register JDBC driver
			String url = "jdbc:mariadb://localhost/mydb"; // like IP address
			con = DriverManager.getConnection(url, dbUser, usrPass);// STEP 3: Open a connection
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	// CleanUp the Db delete all the record details.
	public boolean cleanUPTable() {
		try {
			Connection con = connectToDB();
			Statement stmt = con.createStatement();
			String sql = "truncate table PlayerXml";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			System.out.println("Successfully truncated PlayerXml");
		} catch (Exception e) {
			System.out.println("Could not truncate test_table " + e.getMessage());
			return false;
		}
		return true;
	}

	// check Primarykey Exists are not
	public boolean validatePrimaryKeyExists() {
		try {
			Connection con = connectToDB();
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM information_schema.table_constraints WHERE constraint_type = 'PRIMARY KEY' AND table_name = 'PlayerXml'";
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			if (rs.next() == false) {// checking if ResultSet is empty
				System.out.println("ResultSet is empty");
				return false;
			}

		} catch (Exception e) {
			System.out.println("check primary key failed " + e.getMessage());

		}
		return true;
	}

	// count number of columns in the table
	public int countNumOfColumns() {
		int numOfCols = 0;
		try {
			ResultSet rs = getResultSet();
			ResultSetMetaData rsmd = rs.getMetaData();
			numOfCols = rsmd.getColumnCount();// Get number of columns returned
			for (int i = 1; i <= numOfCols; ++i) {// Print out type for each column
				System.out.println("Column [" + i + "] data type: " + rsmd.getColumnTypeName(i));
			}
		} catch (Exception e) {
			System.out.println("There is an error while counting number of columns");
		}
		return numOfCols;
	}

	// if the element name is not correct it enter defult values as unknow or zero
	// correspoinding to their data type
	// validate based on unknown and zero values ( if count is >1 it returns true
	// otherwise it returns false

	public boolean validateLoadByUnknowAndZero() {
		try {
			Connection con = connectToDB();
			Statement stmt = con.createStatement();
			// check whether user record is present or not
			String sql = "select * from PlayerXml where club=\"unknown\" union select * from PlayerXml where name=\"unknown\" union select * from PlayerXml where age=0 union select * from PlayerXml where MarketValue=0;\r\n"
					+ "";
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			int i = 0;
			while (rs.next()) {

				i++;
			}
			System.out.println("Number of unknown and zero records are " + i);
			if (i > 0) {
				System.out.println("Number of unknown and zero records are " + i);
				return true; // is there
			}
		} catch (Exception e) {
			return false;
		}
		return false;// not there
	}

	// count the number of records
	public int noOfRecoreds() {
		int rowCount = 0;
		try {
			Connection con = connectToDB();
			Statement stmt = con.createStatement();
			String sql = "select * from PlayerXml";
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				rowCount++;
			}
			System.out.println("Number of records is" + rowCount);
		} catch (Exception e) {
			System.out.println("");
		}
		return rowCount;
	}

	// Save the data into your database making sure no duplicate data exists.
	// (Completion)
	public boolean writeToDB(ArrayList<PlayersJava> playerList)
			throws ParserConfigurationException, SAXException, IOException {
		int id = 0;
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document dom = documentBuilder.parse(new File("premierLeaguePlayerNames.xml"));
			NodeList nList = dom.getElementsByTagName("row");
			for (PlayersJava p : playerList) {
				String name1 = p.getName();
				int age1 = p.getAge();
				String club1 = p.getClub();
				String position1 = p.getPosition();
				double marketValue1 = p.getMarketValue();
				String nationality1 = p.getNationality();
				if (!checkDuplicateWhileLoading(name1, age1, club1, position1, marketValue1, nationality1,
						playerList)) {
					try {
						id++;
						Connection con = connectToDB();
						Statement stmt = con.createStatement();
						String sql = "INSERT INTO PlayerXml (PlayerID,Name,Age,Club,Position,MarketValue, nationality )"
								+ "VALUES (?,?, ?, ?,?,?,?)";
						PreparedStatement preparedStatement = con.prepareStatement(sql);
						preparedStatement.setInt(1, id);
						preparedStatement.setString(2, name1);
						preparedStatement.setInt(3, age1);
						preparedStatement.setString(4, club1);
						preparedStatement.setString(5, position1);
						preparedStatement.setDouble(6, marketValue1);
						preparedStatement.setString(7, nationality1);
						try {
							preparedStatement.executeUpdate();
						} catch (Exception e) {

						}

						stmt.close();
						con.close();

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				} else {
					System.out.println("Its a duplicate record.. please enter again");
					dupli++;
				}
			}
			System.out.println("There are " + dupli + " duplicats ");

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(dupli!=0)
		 return false;
		
		return true;
	}

	public Boolean checkDuplicateWhileLoading(String sName, int sAge, String sClub, String sPosition,
			double sMarketValue, String sNationality, ArrayList<PlayersJava> playerList) {
		try {
			int flag = 0;

			for (PlayersJava p : playerList) {

				if (sName.equalsIgnoreCase(p.getName())) {
					String searchName = p.getName();
					int searchAge = p.getAge();
					String searchClub = p.getClub();
					String searchPosition = p.getPosition();
					double searchMarketValue = p.getMarketValue();
					String searchNationality = p.getNationality();
					if (sClub == searchClub && sAge == searchAge && sPosition == searchPosition
							&& searchMarketValue == sMarketValue && sNationality == searchNationality) {
						flag++;
					}
					if (flag == 2) {
						displayToConsole(sName, sAge, sClub, sPosition, sMarketValue, sNationality);
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Filter the data based on a specific input (i.e. name, team, age, nationality,
	// etc.) (Completion)

	// filter the data by name
	public ArrayList<PlayersJava> filterByName(String name) {
		ArrayList<PlayersJava> playersByNames = new ArrayList<>();
		try {

			Connection con = connectToDB();
			Statement stmt = con.createStatement();
			String sql = "Select * from PlayerXml where Name = '" + name + "'";
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("PlayerID");
				name = rs.getString("Name");
				int age = rs.getInt("Age");
				String club1 = rs.getString("Club");
				String position = rs.getString("Position");
				double marketValue = rs.getDouble("MarketValue");
				String nationality = rs.getString("nationality");
				PlayersJava p = new PlayersJava(name, club1, position, marketValue, nationality, age);
				playersByNames.add(p);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return playersByNames;

	}

	// filter the data by club
	public ArrayList<PlayersJava> filterByClub(String club) {
		ArrayList<PlayersJava> playersByClub = new ArrayList<>();
		try {

			Connection con = connectToDB();
			Statement stmt = con.createStatement();
			String sql = "Select * from PlayerXml where Club = '" + club + "'";
			System.out.println(sql);
			// Instead use a PreparedStatement:
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("PlayerID");
				String name = rs.getString("Name");
				int age = rs.getInt("Age");
				String club1 = rs.getString("Club");
				String position = rs.getString("Position");
				double marketValue = rs.getDouble("MarketValue");
				String nationality = rs.getString("nationality");
				PlayersJava p = new PlayersJava(name, club1, position, marketValue, nationality, age);
				playersByClub.add(p);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return playersByClub;

	}

	// filter the data by Nationality
	public ArrayList<PlayersJava> filterByNationality(String nationalitystr) {
		ArrayList<PlayersJava> playersByNationality = new ArrayList<>();
		try {

			Connection con = connectToDB();
			Statement stmt = con.createStatement();
			String sql = "Select * from PlayerXml where nationality = '" + nationalitystr + "'";
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("PlayerID");
				String name = rs.getString("Name");
				int age = rs.getInt("Age");
				String club1 = rs.getString("Club");
				String position = rs.getString("Position");
				double marketValue = rs.getDouble("MarketValue");
				String nationality = rs.getString("nationality");
				PlayersJava p = new PlayersJava(name, club1, position, marketValue, nationality, age);
				playersByNationality.add(p);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return playersByNationality;

	}

	// Check whether id's are unique
	public int countNoOfIDs(int playerID) {
		int count = 0;
		try {

			Connection con = connectToDB();
			Statement stmt = con.createStatement();
			String sql = "Select * from PlayerXml where PlayerID = \"" + playerID + "\"";
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				count++;
				System.out.print("" + rs.getInt("PlayerXml.PlayerID"));
				System.out.print("\t  " + rs.getString("PlayerXml.Name"));
				System.out.print("\t " + rs.getInt("PlayerXml.Age"));
				System.out.print("\t  " + rs.getString("PlayerXml.Club"));
				System.out.print("\t  " + rs.getString("PlayerXml.Position"));
				System.out.print("\t  " + rs.getDouble("PlayerXml.PlayerID"));
				System.out.print("\t " + rs.getString("PlayerXml.nationality"));
				System.out.println();
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public void displayToConsole(String searchName, int sAge, String searchClub, String searchPosition,
			double searchMarketValue, String searchNationality) {
		System.out.println("Name  :: " + searchName);
		System.out.println("Age :: " + sAge);
		System.out.println("Club  :: " + searchClub);
		System.out.println("Position  :: " + searchPosition);
		System.out.println("MarketValue  :: " + searchMarketValue);
		System.out.println("Nationality  :: " + searchNationality);
	}

	// get records and store it into the arraylist of type String
	public ArrayList<String> getRecordAsString() throws SQLException {

		ArrayList<String> recordsAsString = new ArrayList<String>();
		Connection con = connectToDB();
		Statement stmt = con.createStatement();
		String sql = "Select * from PlayerXml";
		System.out.println(sql);
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			String name = rs.getString("PlayerXml.Name");
			int age = rs.getInt("PlayerXml.Age");
			String club1 = rs.getString("PlayerXml.Club");
			String position = rs.getString("PlayerXml.Position");
			double marketValue = rs.getDouble("PlayerXml.MarketValue");
			String nationality = rs.getString("PlayerXml.nationality");
			String str = name + age + club1 + position + marketValue + nationality;
			recordsAsString.add(str);
		}
		return recordsAsString;
	}

	// return the result set;
	public ResultSet getResultSet() {
		ResultSet rs = null;
		try {

			Connection con = connectToDB();
			Statement stmt = con.createStatement();
			String sql = "Select * from PlayerXml";
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			rs = st.executeQuery();
			rs.close();
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (rs);

	}

	// compare data is migrated without any truncate (data maybe data truckated due
	// to data type size)
	public ArrayList<Integer> validateDataTruncate(ArrayList<String> xmlPlayerList, ArrayList<String> dbPlayerList) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		if (xmlPlayerList.size() == dbPlayerList.size()) {
			int n = xmlPlayerList.size();
			int count = 0;
			int arraycount = 0;

			for (int i = 0; i < n; i++) {
				count++;
				if (!xmlPlayerList.get(i).equalsIgnoreCase(dbPlayerList.get(i)))// also a testcase
				{

					array.add(i);
				}
			}
		}
		return (array);
	}

	public static void display(ArrayList<PlayersJava> playersByNames) {

		for (PlayersJava p : playersByNames) {
			System.out.println(p);
		}
		System.out.println("playersByNames" + playersByNames.size());

	}
	// *****************************Main**********************************//
	//
	// public static void main(String[] args) throws ParserConfigurationException,
	// SAXException, IOException, SQLException {
	// // create objects
	// DataMigrationProjectToSubmit dm= new DataMigrationProjectToSubmit();
	// File fXmlFile = new File("premierLeaguePlayerNames.xml");
	//
	//
	// int noOfRecords= dm.totalRecordsInXML(fXmlFile);
	// System.out.println("noOfElements"+noOfRecords);
	//
	//
	// int noOftables=dm.countNumberOfTablesInXML(fXmlFile);
	// System.out.println(noOftables);
	//
	// dm.cleanUPTable();
	//
	// //load xml to arratlist
	// ArrayList<PlayersJava> playerList = dm.load();
	//
	// // load to DB without duplicates
	// boolean loadStatus= dm.writeToDB(playerList);
	// System.out.println(loadStatus);
	//
	// // find no of recors
	// int rowCount=dm.noOfRecoreds();
	// System.out.println(rowCount);
	// //
	// boolean status= dm.validateLoadByUnknowAndZero();
	// System.out.println("validateLoadByUnknowAndZero"+status);
	//
	//
	// boolean statusPk= dm.validatePrimaryKeyExists();
	// System.out.println("validatePrimaryKeyExists "+statusPk);
	//
	//
	// ArrayList<PlayersJava> playerByAge= dm.verifybyAgeXML(playerList,-28);
	// System.out.println(playerByAge.size());
	//
	// ArrayList<PlayersJava> playerByName=
	// dm.verifyByNameXML(playerList,"Kristoffer Nordfeldt");
	// System.out.println(playerByName.size());
	//
	// ArrayList<PlayersJava>
	// playerByNationality=dm.verifybyNationalityXML(playerList,
	// "Manchester+United");
	// System.out.println(playerByNationality.size());
	//
	// ArrayList<PlayersJava> playerByClub=
	// dm.verifybyClubXML(playerList,"Bournemouth");
	// System.out.println(playerByClub.size());
	//
	// ArrayList<String> xmlPlayerList=dm.getAsString(playerList);
	//
	// for(String str: xmlPlayerList)
	// {
	// System.out.println(str);
	//
	// }
	//
	// ArrayList<String> dbPlayerList=dm.getRecordAsString();
	// for(String str: dbPlayerList)
	// {
	// System.out.println(str);
	//
	// }
	//
	// //compare data is migrated without any truncate (data maybe data truckated
	// due to size)
	// if(xmlPlayerList.size()==dbPlayerList.size())
	// {
	// int n=xmlPlayerList.size();
	// int count=0;
	// int arraycount=0;
	// ArrayList<Integer> array= new ArrayList<Integer>();
	// for(int i=0;i<n;i++) {
	// count++;
	// if(!xmlPlayerList.get(i).equalsIgnoreCase(dbPlayerList.get(i)))// also a
	// testcase
	// {
	//
	// array.add(i);
	// }
	// }
	// System.out.println("number of mismatches is "+array.size());
	// }
	//
	//
	//
	//
	//
	//// int count = dsqldb.countNoOfIDs(10);
	//// System.out.println(count);
	//
	// /*////Filter the data based on a specific input (i.e. name, team, age,
	// nationality, etc.) (Completion)
	// int countNationality =dsqldb.filterByNationality("France");
	// System.out.println(countNationality);
	//
	// int countID=dsqldb.filterByID(12);
	// System.out.println(countID);
	//
	// ArrayList<PlayersJava> playersByNames = dsqldb.filterByName("Dharani");
	// display(playersByNames);
	//
	// System.out.println(noOfRecords);
	//
	// ResultSetMetaData rsmd =dsqldb.checkDataTypesOfTable();
	// int numOfCols = rsmd.getColumnCount();
	// //Print out type for each column
	// for(int i=1; i<=numOfCols; ++i)
	// {
	// System.out.println("Column [" + i + "] data type: " +
	// rsmd.getColumnTypeName(i));
	// } */
	//
	// }
	//
	// private static ArrayList<PlayersJava> verifybyAgeXML(int i) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//

}
// https://www.journaldev.com/895/how-to-validate-xml-against-xsd-in-java
