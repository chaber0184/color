package project1;
/**
 * This class opens and reads file containing color names and their hexvalues
 * and displays name hex and RGB  for hex value that user inputs
 * @author Dimitri Chaber
 * @version 9/11/2017
 * 
 */


import java.io.*;
import java.util.*;

public class ColorConverter {
	/**
	 * main method, opens and reads file gathers user input
	 */
	public static void main(String[] args) throws IllegalArgumentException {
		//open file in argument
		File test = null;
		ColorList list = new ColorList();
		Scanner input = new Scanner(System.in);
		String userHex = "";
		//create file object from command line argument
		try {
			test =  new File(args[0]);
		}
		catch(ArrayIndexOutOfBoundsException w) {
			System.err.println("No file in argument");
			System.exit(1);
			
		}
		//check if file exists
	    if( test.exists() == false ) {
	    	System.err.println("File does not exist");
	    	System.exit(1);
		
		}
		Scanner colorInfo = null;
		try {
			colorInfo = new Scanner(test);
		} 
		catch (FileNotFoundException e) {
			
		}
		
		//read contents of file and add them to arraylist
		do {
			
			String tempName = colorInfo.nextLine();
			String [] temp = tempName.split(",");
			temp[0] = temp[0].trim();
			temp[1] = temp[1].trim();
			//System.out.println("Name:"+temp[0]);
			//System.out.println("Hex:"+ ""+temp[1]);
			Color testColor = new Color(temp[1],temp[0]);
			list.add(testColor);

			
		} 
		while(colorInfo.hasNext());
		
		colorInfo.close();
		//user input loop
		while (!userHex.equalsIgnoreCase("quit") ) {
			System.out.println("Enter a hexadecimal value or type quit to terminate the program:");
			userHex = input.next();
			//System.out.println(userHex);
			try {
				System.out.println(list.getColorByHexValue(userHex));
			}
			catch(IllegalArgumentException g) {
				System.err.println("Invalid hex value. must be in format #XXXXXX with X between 0 and F.");
			}
			
		}
		input.close();
		

	}

}
