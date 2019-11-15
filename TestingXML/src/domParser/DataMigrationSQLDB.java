package domParser;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DataMigrationSQLDB {

	// method to connect
	public Connection connectToDB() {
		Connection con = null;
		try {
			// mysql -u myuser -pmypass mydb
			String dbUser = "myuser";
			String usrPass = "mypass";
			Class.forName("org.mariadb.jdbc.Driver"); // STEP 2: Register JDBC driver
			// String url = "jdbc:mysql://10.140.169.253/testjdbc";
			String url = "jdbc:mariadb://localhost/mydb"; // like IP address
			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			con = DriverManager.getConnection(url, dbUser, usrPass);
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
			// A Java MySQL select (using PreparedStatement)
			// check whether user record is present or not
			String sql = "truncate table PlayerXml";
			System.out.println(sql);
			// Instead use a PreparedStatement:
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			System.out.println("Successfully truncated test_table");
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
			// A Java MySQL select (using PreparedStatement)
			// check whether user record is present or not
			String sql = "SELECT * FROM information_schema.table_constraints WHERE constraint_type = 'PRIMARY KEY' AND table_name = 'PlayerXml'";
			System.out.println(sql);
			// Instead use a PreparedStatement:
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			// checking if ResultSet is empty
			if (rs.next() == false) {
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
			// Get number of columns returned
			numOfCols = rsmd.getColumnCount();
			// Print out type for each column
			for (int i = 1; i <= numOfCols; ++i) {
				System.out.println("Column [" + i + "] data type: " + rsmd.getColumnTypeName(i));
			}
		} catch (Exception e) {
			System.out.println("There is an error while counting number of columns");
		}
		return numOfCols;
	}

	// validate there is any duplicates in the DB table
	public boolean validateDuplicateRecord() throws SQLException {
		ResultSet rs = getResultSet();
		ArrayList<ResultSet> recordList = new ArrayList<>();
		// checking if ResultSet is empty
		// if (rs.next() == true) {
		while (rs.next()) {
			recordList.add(rs);
		}
		// }

		return true;

	}

	// if the element name is not correct it enter defult values as unknow or zero
	// correspoinding to their data type
	// validate based on unknown and zero values ( if count is >1 it returns true
	// otherwise it returns false

	public boolean validateLoadByUnknowAndZero() {
		try {
			Connection con = connectToDB();
			Statement stmt = con.createStatement();
			// A Java MySQL select (using PreparedStatement)
			// check whether user record is present or not
			String sql = "select * from PlayerXml where club=\"unknown\" union select * from PlayerXml where name=\"unknown\" union select * from PlayerXml where age=0 union select * from PlayerXml where MarketValue=0;\r\n"
					+ "";
			System.out.println(sql);
			// Instead use a PreparedStatement:
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			// retrieve the values of all returned rows and store them in a list
			int i = 0;
			while (rs.next()) {

				i++;
			}
			System.out.println("Number of unknown and zero records are " + i);
			if (i > 0) {
				System.out.println("Number of unknown and zero records are " + i);
				// ResultSet rs1 = st.executeQuery();
				// while (rs1.next()) {
				// System.out.println("Id" + rs1.getInt("PlayerXml.PlayerID"));
				// System.out.println("Name" + rs1.getString("PlayerXml.Name"));
				// System.out.println("Age" + rs1.getInt("PlayerXml.Age"));
				// System.out.println("Club" + rs1.getString("PlayerXml.Club"));
				// System.out.println("position" + rs1.getString("PlayerXml.Position"));
				// System.out.println("MarketValue" + rs1.getDouble("PlayerXml.MarketValue"));
				// System.out.println("nationality" + rs1.getString("PlayerXml.nationality"));
				// System.out.println("--------------------------------------------------------------------");
				// }
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	//

	// Save the data into your database making sure no duplicate data exists.
	// (Completion)

	public int writeToDB(ArrayList<PlayersJava> playerList)
			throws ParserConfigurationException, SAXException, IOException {
		int id = 0;
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document dom = documentBuilder.parse(new File("premierLeaguePlayerNames.xml"));
			NodeList nList = dom.getElementsByTagName("row");
			int dupli = 0;

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
						// A Java MySQL INSERT example (using PreparedStatement)
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
							// execute the preparedstatement
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
			System.out.println("found duplicats is:" + dupli);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return (id);
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

	// filter the data by Nationality
	public ArrayList<PlayersJava> filterByName(String name) {
		ArrayList<PlayersJava> playersByNames = new ArrayList<>();
		try {

			Connection con = connectToDB();
			Statement stmt = con.createStatement();
			// A Java MySQL select (using PreparedStatement)
			// check whether user record is present or not
			String sql = "Select * from PlayerXml where Name = \"" + name + "\"";

			System.out.println(sql);
			// Instead use a PreparedStatement:
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("PlayerID");
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
			// A Java MySQL select (using PreparedStatement)
			// check whether user record is present or not
			String sql = "Select * from PlayerXml where Club = '"+club+"'";

			System.out.println(sql);
			// Instead use a PreparedStatement:
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("PlayerID");
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
	
	// filter the data by club
		public ArrayList<PlayersJava> filterByAge(int age) {
			ArrayList<PlayersJava> playersByAge = new ArrayList<>();
			try {

				Connection con = connectToDB();
				Statement stmt = con.createStatement();
				// A Java MySQL select (using PreparedStatement)
				// check whether user record is present or not
				String sql = "Select * from PlayerXml where Age = \"" + age + "\"";
				System.out.println(sql);
				// Instead use a PreparedStatement:
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					int id=rs.getInt("PlayerID");
					String name = rs.getString("Name");
					age = rs.getInt("Age");
					String club1 = rs.getString("Club");
					String position = rs.getString("Position");
					double marketValue = rs.getDouble("MarketValue");
					String nationality = rs.getString("nationality");
					PlayersJava p = new PlayersJava(name, club1, position, marketValue, nationality, age);
					playersByAge.add(p);
				}
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return playersByAge;

		}

	// Filter the data based on a specific input (i.e. name, team, age, nationality,
	// etc.) (Completion)
	// filter the data by Nationality
	public ArrayList<PlayersJava> filterByNationality(String nationality) {
		ArrayList<PlayersJava> playersByNationality = new ArrayList<>();
		try {

			Connection con = connectToDB();
			Statement stmt = con.createStatement();

			// A Java MySQL select (using PreparedStatement)
			// check whether user record is present or not
			String sql = "Select * from PlayerXml where nationality = \"" + nationality + "\"";

			System.out.println(sql);
			// Instead use a PreparedStatement:
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id=rs.getInt("PlayerID");
				String name = rs.getString("Name");
				int age = rs.getInt("Age");
				String club1 = rs.getString("Club");
				String position = rs.getString("Position");
				double marketValue = rs.getDouble("MarketValue");
				nationality = rs.getString("nationality");
				PlayersJava p = new PlayersJava(name, club1, position, marketValue, nationality, age);
				playersByNationality.add(p);
			}
			// while (rs.next()) {
			// count++;
			// System.out.print("" + rs.getInt("PlayerXml.PlayerID"));
			// System.out.print("\t " + rs.getString("PlayerXml.Name"));
			// System.out.print("\t " + rs.getInt("PlayerXml.Age"));
			// System.out.print("\t " + rs.getString("PlayerXml.Club"));
			// System.out.print("\t " + rs.getString("PlayerXml.Position"));
			// System.out.print("\t " + rs.getDouble("PlayerXml.PlayerID"));
			// System.out.print("\t " + rs.getString("PlayerXml.nationality"));
			// System.out.println();
			// }
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return playersByNationality;

	}

	// filter the data by Nationality
	public int countNoOfIDs(int playerID) {
		int count = 0;
		try {

			Connection con = connectToDB();
			Statement stmt = con.createStatement();
			// A Java MySQL select (using PreparedStatement)
			// check whether user record is present or not
			String sql = "Select * from PlayerXml where PlayerID = \"" + playerID + "\"";

			System.out.println(sql);
			// Instead use a PreparedStatement:
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

	// nataionality = nataionality
	// get indepentent nationality and its count in hash map--> xml and db match
	//
	public int verifybyNationalityDB() {
		return 0;
	}

	// get records and store it into the arraylist of type String 
	public ArrayList<String> getRecordAsString() throws SQLException{
		
		ArrayList<String> recordsAsString= new ArrayList<String>();
		//ResultSet rs=getResultSet();	
		
		Connection con = connectToDB();
		Statement stmt = con.createStatement();

		// A Java MySQL select (using PreparedStatement)
		// check whether user record is present or not
		String sql = "Select * from PlayerXml";

		System.out.println(sql);
		// Instead use a PreparedStatement:
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {			
			String name = rs.getString("PlayerXml.Name");
			int age = rs.getInt("PlayerXml.Age");
			String club1 = rs.getString("PlayerXml.Club");
			String position = rs.getString("PlayerXml.Position");
			double marketValue = rs.getDouble("PlayerXml.MarketValue");
			String nationality = rs.getString("PlayerXml.nationality");	
			String str=name+age+club1+position+marketValue+nationality;
			recordsAsString.add(str);
		}		
		return recordsAsString;		
	}
	
	
	
	// return the result set;
	public ResultSet getResultSet() {
		// ResultSetMetaData rsmd = null;
		ResultSet rs = null;

		try {

			Connection con = connectToDB();
			Statement stmt = con.createStatement();

			// A Java MySQL select (using PreparedStatement)
			// check whether user record is present or not
			String sql = "Select * from PlayerXml";

			System.out.println(sql);
			// Instead use a PreparedStatement:
			PreparedStatement st = con.prepareStatement(sql);
			rs = st.executeQuery();
			// rsmd = rs.getMetaData();
			// //Get number of columns returned
			// int numOfCols = rsmd.getColumnCount();
			//
			// //Print out type for each column
			// for(int i=1; i<=numOfCols; ++i)
			// {
			// System.out.println("Column [" + i + "] data type: " +
			// rsmd.getColumnTypeName(i));
			// }
			rs.close();
			stmt.close();
			con.close();
		

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (rs);

	}

}

// to test
// 461
// Test cases:
// 1. check same data is migrated
// 2. check same data type is migrated
// 3. update xml then update db
// basic tag name are sames
//
// reload and check the count of records is same as before

/*
 * //Get number of columns returned int numOfCols = rsmd.getColumnCount();
 */
