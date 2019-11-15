package activitythree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ToTest {

	private static ArrayList<String> fileList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		WordCount n = new WordCount();
		ActivityThreeToRunExternalCommands a = new ActivityThreeToRunExternalCommands();
		
		String fileName="alice29.txt";
		String word="the";
//		File folder = new File("C:\\Users\\bollindhar\\Desktop\\testing\\TestingFolder");
//		File[] listOfFiles = folder.listFiles();
//
//		for (int i = 0; i < listOfFiles.length; i++) {
//		  File file = listOfFiles[i];
//		  String fileName1=listOfFiles[i].toString();
//		  fileList.add(fileName1);
//		  }
//		for(int i = 0; i < fileList.size(); i++) {
//			System.out.println("Test");
//			System.out.println(fileList.get(i));
//		}
//		  
//		for(int i = 0; i < fileList.size(); i++) {
//			/* do somthing with content */
//			String fileName=fileList.get(i);
		    int countWordCount = n.countMethod(fileName, word);
			int countWindow = a.ToCountMethodCmd(fileName, word);
			System.out.println("countWordCount "+countWordCount);
			System.out.println("countWindow "+countWindow);
			
			if (countWordCount == countWindow) {
				System.out.println("They are same");
			}
			else
			{
				System.out.println("They are not same");
			}
		  } 
		}
//	}




