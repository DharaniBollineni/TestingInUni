package myMathCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyMathUtil {

	public static int add(int a, int b) {
		return (a + b);
	}

	public static int sub(int a, int b) {
		return (a - b);
	}

	public static int mult(int a, int b) {
		return (a * b);
	}
	
	public static boolean isPrime(int n) 
	{ 
	    // Corner case 
	    if (n <= 1) 
	        return false; 
	  
	    // Check from 2 to n-1 
	    for (int i = 2; i < n; i++) 
	        if (n % i == 0) 
	            return false; 
	  
	    return true; 
	} 
	
	public static int ToCountMethodCmd (String fileName, String inputStr) throws Exception{
		System.out.println("Starting process");
		Runtime rt = Runtime.getRuntime();
		int countWindow=0;
		String cmd1="find /c"+" "+'"'+inputStr+'"'+" "+'"'+fileName+'"';
		System.out.println("cmd: " + cmd1);
		Process pr = rt.exec(cmd1);
		BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line=null;
		input.readLine(); // empty
		line = input.readLine();// next line
 		StringTokenizer sT = new StringTokenizer(line, ":");//separator is :
		sT.nextToken();		
		String s = sT.nextToken().trim();
		return Integer.parseInt(s);		
		}
	
	public static int countMethod(String fileName, String input) throws IOException {

		File f1 = new File(fileName); // Creation of File Descriptor for input file
		String[] words = null; // Intialize the word Array
		FileReader fr = new FileReader(f1); // Creation of File Reader object
		BufferedReader br = new BufferedReader(fr); // Creation of BufferedReader object
		String s;
		// String input="Java"; // Input word to be searched
		int count = 0; // Intialize the word to zero
		while ((s = br.readLine()) != null) // Reading Content from the file
		{
			words = s.split(" "); // Split the word using space
			for (String word : words) {
				//if (word.equals(input)) // Search for the given word
				//if(word.contains(input))
				if(word.equalsIgnoreCase(input))
				{
					count++; // If Present increase the count by one
				}		
			}
		}
		if (count != 0) // Check for count not equal to zero
		{
			System.out.println("The given word is present for " + count + " Times in the file");
		} else {
			System.out.println("The given word is not present in the file");
		}
		fr.close();
		return count;

	}
	
	
	
	


}
