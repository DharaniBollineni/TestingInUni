package parametrisedjUnit;

import java.io.File;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class xmlNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void load()
	{
		try
		{
			File fxmlFile = new File("D:\\");
			DocumentBuilderFactory dbFactory =DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder=  dbFactory.newDocumentBuilder();
			Document doc=dBuilder.parse(fXMLFile);
			Node 
			
		}
	}

}
