package parameterizedTest;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DMParameterizeUtilityToSubmit {

	ArrayList<PlayersJava> xmlPlayerList = new ArrayList<PlayersJava>();

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

	public ArrayList<PlayersJava> load() {

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
						name = "unknown";// System.out.println("Error because of name");
				}
				
				try {
					age = Integer.parseInt(e.getElementsByTagName("age").item(0).getTextContent());
				} catch (Exception e1) {
							age = 0;// System.out.println("Error because of name");
				}
				try {
					club = e.getElementsByTagName("club").item(0).getTextContent();
				} catch (Exception e1) {
							club = "unknown";// System.out.println("Error because of name");
				}
				try {
					position = e.getElementsByTagName("position").item(0).getTextContent();
				} catch (Exception e1) {
							position = "unknown";// System.out.println("Error because of name");
				}

				try {
					marketValue = Double.parseDouble(e.getElementsByTagName("market_value").item(0).getTextContent());
				} catch (Exception e1) {
							marketValue = 0.0;// System.out.println("Error because of name");
				}

				try {
					nationality = e.getElementsByTagName("nationality").item(0).getTextContent();
				} catch (Exception e1) {
							nationality = "unknown";// System.out.println("Error because of name");
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

	// Save the data into your database making sure no duplicate data exists.
	// (Completion)

	public boolean writeToDB(ArrayList<PlayersJava> playerList)
			throws ParserConfigurationException, SAXException, IOException {
		int dupli = 0;
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
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Count records by age in xml
	public int verifybyAgeXML(ArrayList<PlayersJava> playerList, int sAge) {
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
		return playerByAge.size();

	}

	// Count records by club in xml
	public int verifybyClubXML(ArrayList<PlayersJava> playerList, String club) {
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
		return playerByClub.size();
	}

	// Count records nationality in xml
	public int verifybyNationalityXML(ArrayList<PlayersJava> playerList, String sNationality) {
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

		return playerByNationality.size();

	}

	
	// count records by name in xml
	public int verifyByNameXML(ArrayList<PlayersJava> playerList, String sName) {
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
		return playerByName.size();
	}
	
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
		
		// filter the data by Nationality
					public int filterByNationality(String nationalitystr) {
						ArrayList<PlayersJava> playersByNationality = new ArrayList<>();
						try {

							Connection con = connectToDB();
							Statement stmt = con.createStatement();
							String sql = "Select * from PlayerXml where nationality = '"+nationalitystr+"'";
							System.out.println(sql);
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
								playersByNationality.add(p);
							}
							rs.close();
							stmt.close();
							con.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						return playersByNationality.size();

					}
					
					// filter the data by club
					public int filterByClub(String club) {
						ArrayList<PlayersJava> playersByClub = new ArrayList<>();
						try {

							Connection con = connectToDB();
							Statement stmt = con.createStatement();
							String sql = "Select * from PlayerXml where Club = '"+club+"'";
							System.out.println(sql);
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
						return playersByClub.size();

					}



}
