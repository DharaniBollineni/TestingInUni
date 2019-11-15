package domParser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

// Document Buidler
public class DataLoaderDuplicate {
	public void load() {
		//Allow the user to specify the XML file. Please use premierLeaguePlayerNames.xml we have seen before. (Core)
		//Parse the XML file to display the players’ data. (Core)
		try {
			File fXmlFile = new File("premierLeaguePlayerNames.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("row");

			ArrayList<PlayersJava> playerList = new ArrayList<PlayersJava>();

			for (int i = 0; i < nList.getLength(); i++) {
				Node n = nList.item(i);

				Element e = (Element) n;
				// Player p = new Player (
				// System.out.println(e.getElementsByTagName("name").item(0).getTextContent());
				// System.out.println(e.getElementsByTagName("club").item(0).getTextContent());
				// System.out.println(e.getElementsByTagName("position").item(0).getTextContent());
				// System.out.println(e.getElementsByTagName("market_value").item(0).getTextContent());
				// System.out.println(e.getElementsByTagName("nationality").item(0).getTextContent());

				// playerList.add(p);

				String name = e.getElementsByTagName("name").item(0).getTextContent();
				String club = e.getElementsByTagName("club").item(0).getTextContent();
				String position = e.getElementsByTagName("position").item(0).getTextContent();
				double marketValue = Double
						.parseDouble(e.getElementsByTagName("market_value").item(0).getTextContent());
				String nationality = e.getElementsByTagName("nationality").item(0).getTextContent();
				PlayersJava p = new PlayersJava(name, club, position, marketValue, nationality);
				playerList.add(p);

			}

			for (PlayersJava p : playerList)
				System.out.println(p);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void write1(String name1, String club1, String position1, String market_value1, String nationality1)
			throws ParserConfigurationException, SAXException, IOException {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document dom = documentBuilder.parse(new File("premierLeaguePlayerNames.xml"));

			// root element
			Element root = dom.getDocumentElement();

			// add row
			Element row = dom.createElement("row");
			root.appendChild(row);

			// add name element
			Element newName = dom.createElement("name");
			newName.appendChild(dom.createTextNode(name1));
			row.appendChild(newName); // add name element to row
			// add club element
			Element newClub = dom.createElement("club");
			newClub.appendChild(dom.createTextNode(club1));
			row.appendChild(newClub);

			// add position element
			Element newPosition = dom.createElement("position");
			newPosition.appendChild(dom.createTextNode(position1));
			row.appendChild(newPosition);

			// add market_value element
			Element newMarketValue = dom.createElement("market_value");
			newMarketValue.appendChild(dom.createTextNode(market_value1));
			row.appendChild(newMarketValue);

			// add nationality element
			Element newNationality = dom.createElement("nationality");
			newNationality.appendChild(dom.createTextNode(nationality1));
			row.appendChild(newNationality);

			// transform the DOM Object to an XML File
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StreamResult result = new StreamResult("premierLeaguePlayerNames.xml");
			DOMSource source = new DOMSource(dom);
			transformer.transform(source, result); // saved the updates to file

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	//Save the data into your database making sure no duplicate data exists. (Completion)

	public static void writeWithoutDuplicates(String name1, String club1, String position1, String market_value1,
			String nationality1) throws ParserConfigurationException, SAXException, IOException {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document dom = documentBuilder.parse(new File("premierLeaguePlayerNames.xml"));
			NodeList nList = dom.getElementsByTagName("row");
			
			if (!searchByElement( name1,  club1,  position1,  market_value1, nationality1)) {
				// root element
				Element root = dom.getDocumentElement();

				// add row
				Element row = dom.createElement("row");
				root.appendChild(row);

				// add name element

				Element newName = dom.createElement("name");
				newName.appendChild(dom.createTextNode(name1));
				row.appendChild(newName); // add name element to row
				// add club element
				Element newClub = dom.createElement("club");
				newClub.appendChild(dom.createTextNode(club1));
				row.appendChild(newClub);

				// add position element
				Element newPosition = dom.createElement("position");
				newPosition.appendChild(dom.createTextNode(position1));
				row.appendChild(newPosition);

				// add market_value element
				Element newMarketValue = dom.createElement("market_value");
				newMarketValue.appendChild(dom.createTextNode(market_value1));
				row.appendChild(newMarketValue);

				// add nationality element
				Element newNationality = dom.createElement("nationality");
				newNationality.appendChild(dom.createTextNode(nationality1));
				row.appendChild(newNationality);

				// transform the DOM Object to an XML File
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				StreamResult result = new StreamResult("premierLeaguePlayerNames.xml");
				DOMSource source = new DOMSource(dom);
				transformer.transform(source, result); // saved the updates to file
			} else {
				System.out.println("Its a duplicate record.. please enter again");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
//Filter the data based on a specific input (i.e. name, team, age, nationality, etc.) (Completion)
	public static Boolean searchByElement(String sName,String sClub,String sPosition,String sMarketValue,String sNationality) {
		try {
			int flag = 0;
			File fXmlFile = new File("premierLeaguePlayerNames.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			NodeList nList = doc.getElementsByTagName("row");
			for (int i = 0; i < nList.getLength(); i++) {
				Node n = nList.item(i);
				Element e = (Element) n;
				if (sName.equalsIgnoreCase(e.getElementsByTagName("name").item(0).getTextContent())) {
					String searchName= e.getElementsByTagName("name").item(0).getTextContent();
					String searchClub = e.getElementsByTagName("club").item(0).getTextContent();
					String searchPosition =e.getElementsByTagName("position").item(0).getTextContent();
					String searchMarketValue = e.getElementsByTagName("market_value").item(0).getTextContent();
					String searchNationality= e.getElementsByTagName("nationality").item(0).getTextContent();
					if(sClub==searchClub&& sPosition==searchPosition && searchMarketValue==sMarketValue && sNationality==searchNationality)
						display(sName, sClub, sPosition, sMarketValue, sNationality);						
						return true;
					}
				}
			} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	public static void display(String searchName,String searchClub,String searchPosition,String searchMarketValue, String searchNationality) {
		
		System.out.println("Name  :: "+searchName);
		System.out.println("Club  :: " + searchClub);
		System.out.println("Position  :: " + searchPosition);
		System.out.println("MarketValue  :: " + searchMarketValue);
		System.out.println("Nationality  :: " + searchNationality);
		
		
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		DataLoaderDuplicate dL = new DataLoaderDuplicate();
		dL.load();

		System.out.println("test1");
		String name1 = "Kiran";
		String club1 = "Arsenal";
		String position1 = "LW";
		String marketValue1 = "23.2";
		String nationality1 = "NewZealand";
		System.out.println("test2");

//		dL.write(name1,club1,position1,marketValue1,nationality1);

		System.out.println("test3");
		// dL.load();
//		Boolean flag=dL.searchByElement("Alex Iwobi","Arsenal","LW","23.2","NewZealand");
		if (dL.searchByElement("Alex Iwobi12","Arsenal","LW","23.2","NewZealand")==false) {
			System.out.println("Record doesn't exits");
		}
		
//		dL.searchByElement("Dharaniqwqeqw");
		//dL.writeWithoutDuplicates(name1, club1, position1, marketValue1, nationality1);

	}
}

// xml validation note:
//------------------------------------------------------------------------------------------------------------
//Actually the XSD is XML itself. Its purpose is to validate the structure of another XML document. 
//The XSD is not mandatory for any XML, but it assures that the XML could be used for some particular purposes. 
//The XML is only containing data in suitable format and structure.