package domParser;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DataMigration {
	private ArrayList<PlayersJava> playerList;

	public DataMigration() throws ParserConfigurationException, SAXException, IOException {
		// Parse the XML file to display the players’ data. (Core)
		load();

		// Save the data into your database making sure no duplicate data exists.
		// (Completion)
		writeToDB();

	}

	public void load() {
		// Allow the user to specify the XML file. Please use
		// premierLeaguePlayerNames.xml we have seen before. (Core)
		// Parse the XML file to display the players’ data. (Core)
		try {
			playerList = new ArrayList<PlayersJava>();
			File fXmlFile = new File("premierLeaguePlayerNames.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			NodeList nList = doc.getElementsByTagName("row");
			for (int i = 0; i < nList.getLength(); i++) {
				Node n = nList.item(i);
				Element e = (Element) n;
				String name = e.getElementsByTagName("name").item(0).getTextContent();
				int age = Integer.parseInt(e.getElementsByTagName("age").item(0).getTextContent());
				// int age =
				// Integer.valueOf(e.getElementsByTagName("age").item(0).getTextContent());
				String club = e.getElementsByTagName("club").item(0).getTextContent();
				String position = e.getElementsByTagName("position").item(0).getTextContent();
				double marketValue = Double
						.parseDouble(e.getElementsByTagName("market_value").item(0).getTextContent());
				String nationality = e.getElementsByTagName("nationality").item(0).getTextContent();
				PlayersJava p = new PlayersJava(name, club, position, marketValue, nationality, age);
				playerList.add(p);

			}

			System.out.println("test1");
			for (PlayersJava p : playerList) {
				System.out.println(p);
			}
			System.out.println(playerList.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Save the data into your database making sure no duplicate data exists.
	// (Completion)

	public void writeToDB() throws ParserConfigurationException, SAXException, IOException {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document dom = documentBuilder.parse(new File("premierLeaguePlayerNames.xml"));
			NodeList nList = dom.getElementsByTagName("row");
			int dupli = 0;
			int id = 0;
			for (PlayersJava p : playerList) {
				String name1 = p.getName();
				int age1 = p.getAge();
				String club1 = p.getClub();
				String position1 = p.getPosition();
				double marketValue1 = p.getMarketValue();
				String nationality1 = p.getNationality();				
				if (!checkDuplicate(name1, age1, club1, position1, marketValue1, nationality1)) {
					try {
						id++;
						// mysql -u myuser -pmypass mydb
						String dbUser = "myuser";
						String usrPass = "mypass";
						Class.forName("org.mariadb.jdbc.Driver"); // STEP 2: Register JDBC driver

						Connection con = null;

						// String url = "jdbc:mysql://10.140.169.253/testjdbc";
						String url = "jdbc:mariadb://localhost/mydb"; // like IP address

						// STEP 3: Open a connection
						System.out.println("Connecting to a selected database...");
						con = DriverManager.getConnection(url, dbUser, usrPass);
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

						// execute the preparedstatement
						preparedStatement.executeUpdate();

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
			System.out.println("found duplicats is:"+dupli);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	// Filter the data based on a specific input (i.e. name, team, age, nationality,
	// etc.) (Completion)
	public Boolean checkDuplicate(String sName, int sAge, String sClub, String sPosition, double sMarketValue,
			String sNationality) {
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
						display(sName, sAge, sClub, sPosition, sMarketValue, sNationality);
						flag++;
					}
					if (flag == 2) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public static void display(String searchName, int sAge, String searchClub, String searchPosition,
			double searchMarketValue, String searchNationality) {

		System.out.println("Name  :: " + searchName);
		System.out.println("Age :: " + sAge);
		System.out.println("Club  :: " + searchClub);
		System.out.println("Position  :: " + searchPosition);
		System.out.println("MarketValue  :: " + searchMarketValue);
		System.out.println("Nationality  :: " + searchNationality);

	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		DataMigration dL = new DataMigration();
	}

}

// xml validation note:
// ------------------------------------------------------------------------------------------------------------
// Actually the XSD is XML itself. Its purpose is to validate the structure of
// another XML document.
// The XSD is not mandatory for any XML, but it assures that the XML could be
// used for some particular purposes.
// The XML is only containing data in suitable format and structure.