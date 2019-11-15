package domParser;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class InterfaceXMLandSQL {
	
	public static void display(ArrayList<PlayersJava> playersByNames) {
		
		for (PlayersJava p : playersByNames) {
			System.out.println(p);
		}		
		System.out.println("playersByNames"+playersByNames.size());
		
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, SQLException {
		// create objects
		DataMigrationXML dxml= new DataMigrationXML();
		DataMigrationSQLDB dsqldb= new DataMigrationSQLDB();	
		
		boolean sV=dxml.validateSchema();
		System.out.println("validateSchema "+sV);
		
		int noOfElements= dxml.totalElementsInXML();
		System.out.println(noOfElements);
		
		File fXmlFile = new File("premierLeaguePlayerNames.xml");
		int noOftables=dxml.countNumberOfTablesInXML(fXmlFile);
		System.out.println(noOftables);	
		
		dsqldb.cleanUPTable();		
		
		//load xml to arratlist		
		ArrayList<PlayersJava> playerList = dxml.load();
		
		// load to DB without duplicates 
		int noOfRecords= dsqldb.writeToDB(playerList);
		System.out.println(noOfRecords);
		
		// 
		boolean status= dsqldb.validateLoadByUnknowAndZero();
		System.out.println("validateLoadByUnknowAndZero"+status);
		
		
		boolean statusPk= dsqldb.validatePrimaryKeyExists();
		System.out.println("validatePrimaryKeyExists "+statusPk);
		
		
		ArrayList<PlayersJava> playerByAge= dxml.verifybyAgeXML(playerList,-28);
		System.out.println(playerByAge.size());
		
		ArrayList<PlayersJava> playerByName= dxml.verifyByNameXML(playerList,"Kristoffer Nordfeldt");
		System.out.println(playerByName.size());
		
		ArrayList<PlayersJava> playerByNationality=dxml.verifybyNationalityXML(playerList, "Manchester+United");
		System.out.println(playerByNationality.size());
		
		ArrayList<PlayersJava> playerByClub= dxml.verifybyClubXML(playerList,"Bournemouth");
		System.out.println(playerByClub.size());
		
		ArrayList<String> xmlPlayerList=dxml.getAsString(playerList);
		
		for(String str: xmlPlayerList)
		{
			System.out.println(str);
			
		}
		
		ArrayList<String> dbPlayerList=dsqldb.getRecordAsString();		
		for(String str: dbPlayerList)
		{
			System.out.println(str);
			
		}
		
		//compare data is migrated without any truncate (data maybe data truckated due to size)
		if(xmlPlayerList.size()==dbPlayerList.size())
		{
			int n=xmlPlayerList.size();
			int count=0;
			int arraycount=0;
			ArrayList<Integer> array= new ArrayList<Integer>();
			for(int i=0;i<n;i++) {
				count++;
				if(!xmlPlayerList.get(i).equalsIgnoreCase(dbPlayerList.get(i)))// also a testcase
				{
					
					array.add(i);
				}
				
			}
			System.out.println("number of mismatches is "+array.size());
		}
		
		
		
		
		
//		int count = dsqldb.countNoOfIDs(10);
//		System.out.println(count);
		
//		////Filter the data based on a specific input (i.e. name, team, age, nationality, etc.) (Completion)
		 ArrayList<PlayersJava> countNationality =dsqldb.filterByNationality("France");
		System.out.println(countNationality.size());
		
	////Filter the data based on a specific input (i.e. name, team, age, nationality, etc.) (Completion)
			 ArrayList<PlayersJava> countClub =dsqldb.filterByClub("Southampton");
			System.out.println(countClub.size());
		//int countID=dsqldb.filterByID(12);
	//	System.out.println(countID);
		
		ArrayList<PlayersJava> playersByNames = dsqldb.filterByName("Dharani");
		System.out.println(playersByNames.size());
		display(playersByNames);
		
		ArrayList<PlayersJava> playersByAge = dsqldb.filterByAge(33);
		System.out.println("playersByAge"+playersByAge.size());
		
		int cid= dsqldb.countNoOfIDs(10) ;
		System.out.println("cid"+cid);		
		
		/*ResultSetMetaData rsmd =dsqldb.checkDataTypesOfTable();
		  int numOfCols = rsmd.getColumnCount();
		 //Print out type for each column
        for(int i=1; i<=numOfCols; ++i)
        {
             System.out.println("Column [" + i + "] data type: " + rsmd.getColumnTypeName(i));
        } */
        
       }

	private static ArrayList<PlayersJava> verifybyAgeXML(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}



