package domParser;

import java.io.File;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DataMigrationXML {
	
	private ArrayList<PlayersJava> xmlPlayerList;
	
	public NodeList getNodeList(File fXmlFile) throws ParserConfigurationException, SAXException, IOException
	{
		NodeList nList = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			nList = doc.getElementsByTagName("row");
			return nList;			
		}catch (Exception e) {
			e.printStackTrace();
		}			
		return nList;
	}
	
	//https://www.journaldev.com/895/how-to-validate-xml-against-xsd-in-java
	public boolean validateSchema() throws MalformedURLException
	{
			try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("premierLeaguePlayerNames.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File("premierLeaguePlayerNames.xml")));
            System.out.println("successfully schema is validated");
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
			return true;        
    }

//		URL schemaFile = new URL("premierLeaguePlayerNames.xsd");
//		Source xmlFile = new StreamSource(new File("premierLeaguePlayerNames.xml"));
//		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//		try {
//			  Schema schema = schemaFactory.newSchema(schemaFile);
//			  Validator validator = schema.newValidator();
//			  validator.validate(xmlFile);
//			  System.out.println(xmlFile.getSystemId() + " is valid");
//			} catch (SAXException e) {
//			  System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
//			} catch (IOException e) {}
//		
		
		
//		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder dBuilder;
//		try {
//			dBuilder = dbFactory.newDocumentBuilder();
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Document doc;
//		try {
//			doc = dBuilder.parse(fXmlFile);
//		} catch (SAXException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		NodeList nList = doc.getElementsByTagName("row");
		//return true;
		
	//}
	
	public int countNumberOfTablesInXML(File fXmlFile)
	{
		NodeList nList = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			nList = doc.getElementsByTagName("root");			
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return nList.getLength();			
	}
	
	public int totalElementsInXML() throws ParserConfigurationException, SAXException, IOException
	{
		File fXmlFile = new File("premierLeaguePlayerNames.xml");
		NodeList nList = getNodeList(fXmlFile);
		int count= nList.getLength();
		return count;
	}
	
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
				}catch(Exception e1) {
					//System.out.println("Error because of name");
					name = "unknown";					
				}
				
				try {
					age= Integer.parseInt(e.getElementsByTagName("age").item(0).getTextContent());					
					}catch(Exception e1) {
						//System.out.println("Error because of name");
						age = 0;						
					}
				// int age =
				// Integer.valueOf(e.getElementsByTagName("age").item(0).getTextContent());
				try{
					club = e.getElementsByTagName("club").item(0).getTextContent();
				}catch(Exception e1) {
					//System.out.println("Error because of name");
					club = "unknown";						
				}
				try{
					position = e.getElementsByTagName("position").item(0).getTextContent();
				}catch(Exception e1) {
					//System.out.println("Error because of name");
					position = "unknown";						
				}
				
				try{
					marketValue = Double.parseDouble(e.getElementsByTagName("market_value").item(0).getTextContent());
				}catch(Exception e1) {
					//System.out.println("Error because of name");
					marketValue = 0.0;						
				}
				
				try{
					nationality = e.getElementsByTagName("nationality").item(0).getTextContent();
				}catch(Exception e1) {
					//System.out.println("Error because of name");
					nationality = "unknown";					
				}				
				PlayersJava p = new PlayersJava(name, club, position, marketValue, nationality, age);
				xmlPlayerList.add(p);

			}

			System.out.println("test1");
			for (PlayersJava p : xmlPlayerList) {
				System.out.println(p);
			}
			System.out.println(xmlPlayerList.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlPlayerList;

	}
	// store data of players arraylist to string type arraylist used for comparision of data stored without truncate
	public ArrayList<String> getAsString(ArrayList<PlayersJava> playerList){
		ArrayList<String> strList= new ArrayList<String>();		
		for (PlayersJava p : playerList) {
			String str=p.getName()+p.getAge()+p.getClub()+p.getPosition()+p.getMarketValue()+p.getNationality();
			strList.add(str);
		}		
		return strList;
	}
	
	
	//Count records by age in xml
			public ArrayList<PlayersJava> verifybyAgeXML(ArrayList<PlayersJava> playerList,int sAge)
			{	ArrayList<PlayersJava> playerByAge= new ArrayList<>();
				try {					
					for (PlayersJava p : playerList) {
						if (sAge==p.getAge()) {
							playerByAge.add(p);
						}
					}					
				} catch (Exception e) {
					e.printStackTrace();
					}
				
				return playerByAge;
				
			}
			

			//Count records by club in xml
					public ArrayList<PlayersJava> verifybyClubXML(ArrayList<PlayersJava> playerList,String club)
					{	ArrayList<PlayersJava> playerByClub= new ArrayList<>();
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
		//Count records nationality  in xml
		public ArrayList<PlayersJava> verifybyNationalityXML(ArrayList<PlayersJava> playerList,String sNationality)
		{	ArrayList<PlayersJava> playerByNationality= new ArrayList<>();
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
		
		//count records by name in xml
		public ArrayList<PlayersJava> verifyByNameXML(ArrayList<PlayersJava> playerList,String sName)
		{	ArrayList<PlayersJava> playerByName= new ArrayList<>();
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
		
		//
		
}
	
	//Filter the data based on a specific input (i.e. name, team, age, nationality, etc.) (Completion)
//		public Boolean FilterforSpecificInput(ArrayList<PlayersJava> xmlPlayerList)
//		{
//			try {
//				int flag = 0;
//
//				for (PlayersJava p : xmlPlayerList) {
//
//					if (sName.equalsIgnoreCase(p.getName())) {
//						String searchName = p.getName();
//						int searchAge = p.getAge();
//						String searchClub = p.getClub();
//						String searchPosition = p.getPosition();
//						double searchMarketValue = p.getMarketValue();
//						String searchNationality = p.getNationality();
//						if (sClub == searchClub && sAge == searchAge && sPosition == searchPosition
//								&& searchMarketValue == sMarketValue && sNationality == searchNationality) {
//							flag++;
//						}
//						if (flag == 2) {
//							displayToConsole(sName, sAge, sClub, sPosition, sMarketValue, sNationality);
//							return true;
//						}
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return false;
//		}
//			
//		}


