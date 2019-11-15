package activitythree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JavaWindowsRunActive3 {
	//find command searches for text strings in files and returns the lines of text from the files in which the text string was found.
	public static int toCountInWindowSide(String fileName, String inputStr) throws IOException {
		int countWindow=0;
		String cmd1="find /c"+" "+'"'+inputStr+'"'+" "+'"'+fileName+'"';
		String line=null;
		
		System.out.println("Starting process");
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec(cmd1); //the process created by the exec method does not own a console. Therefore, redirecting its input, output, and error in the standard file is ruled out. Instead, it redirects (stdin, stdout, stderr) to the parent process. If need be, we can access them via streams obtained using methods defined in the class, such as getInputStream(), getOutputStream() and getErrorSteam(). These are the ways we can feed input to and get results from the sub processes. However, there's a catch: There the standard input and output buffers have a limited size as defined by the underlying platform.
		
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(pr.getInputStream())); // redirecting its output to bufferReader
//		//input.readLine();//  empty line
//		while((line=inputReader.readLine()) != null) {
//			StringTokenizer sT = new StringTokenizer(inputStr);//checks for inputstr and store it
//			countWindow+=sT.countTokens();//count no of tokens
//			line = inputReader.readLine();				
//			}				
//		return countWindow;
//		String line=null;
		inputReader.readLine(); // empty
		line = inputReader.readLine();// next line
 //with out while it works for /c
		StringTokenizer sT = new StringTokenizer(line, ":");//separator is :
		sT.nextToken();		
		String s = sT.nextToken().trim();
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		int count = toCountInWindowSide("alice29.txt", "the");
		System.out.println("my count = " + count);	

	}

}
