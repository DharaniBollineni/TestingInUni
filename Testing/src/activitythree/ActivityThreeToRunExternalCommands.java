package activitythree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.print.DocFlavor.READER;

public class ActivityThreeToRunExternalCommands {
	
	public static int ToCountMethodCmd (String fileName, String inputStr) throws Exception{
		System.out.println("Starting process");
		Runtime rt = Runtime.getRuntime();
		int countWindow=0;
		String cmd1="find /c"+" "+'"'+inputStr+'"'+" "+'"'+fileName+'"';
		//String cmd1="find /c"+" "+'"'+inputStr+'"'+" "+'"'+fileName+'"';
		System.out.println("cmd: " + cmd1);
		Process pr = rt.exec(cmd1);
		//Process pr = rt.exec("find /c \"Testing\" testInputword.txt");
		BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line=null;
		input.readLine(); // empty
		line = input.readLine();// next line
		//with out while it works for /c
		StringTokenizer sT = new StringTokenizer(line, ":");//separator is :
		sT.nextToken();		
		String s = sT.nextToken().trim();
		System.out.println("s is"+s);
		return Integer.parseInt(s);		
		}

	public static void main(String[] args) throws Exception {
//		new ActivityThreeToRunExternalCommands("testInputword.txt", "Hello");  
//		new ActivityThreeToRunExternalCommands("testInputword.txt", "hello"); 
//		
		int count = ToCountMethodCmd("testInputword.txt", "Hello");
		System.out.println("my count = " + count);	
		
		
		//line = input.readLine();
	}

}
