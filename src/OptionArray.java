/**
 * CSE 205: 11333 / T TH 4:30pm
 * Honors Project
 * Author: Thaddeus Shinno & 1216639502
 * Descripion: Class that manages user input and displays help menu
 */

import java.io.*;

public class OptionArray {
	private String[] args;
	
	// help message
	private String help = "Usage: java PortScan [options] [ip]\n"
						+ "OPTIONS:\n"
						+ "\t -o [basename]: Output to [basename].txt\n"
						+ "\t -c: only scan the 20 most common ports\n"
						+ "\t -h: Print this help summary page\n"
						+ "EXAMPLE:\n"
						+ "java PortScan -c -o openports 168.92.0.1\n"
						+ "\t (this scans the 20 most common ports on the ip address 168.92.0.1 and saves to an output called openports.txt)";
	
	/**
	 * default constructor
	 */
	public OptionArray() {
		this.args = null;
	}
	
	/**
	 * An option array is just a String array with extra methods
	 */
	public OptionArray(String[] args) {
		this.args = args;
	}
	
	/**
	 * returns a string of all options in args and inserts spaces before
	 */
	public String getArgs() {
		String options = "";
		for (int i = 0; i < this.args.length; i++) {
			options += " " + this.args[i];
		}
		options += "\n";
		return options;
	}
	
	/**
	 * Validate user input and display the help message if necessary
	 */
	public boolean checkOptions() {
		// check if there are any options at all
		if (args.length < 1) {
			System.out.println(help);
			return false;
		}
		
		// print the help message
		if (contains("-h") || contains("--help") || contains("-help") || contains("help") ) {
			System.out.println(help);
			return false;
		}
		
		// user doesn't need help
		return true;
	}
	
	/**
	 * Outputs string to a file
	 */
	public static void save(String out, String basename) {
		// if the basename begins with a '-' or contains '.' then return with a basename prompt
		if (basename.charAt(0) == '-' || basename.contains(".")) {
			System.out.println("***Could not output text file. Basename must not begin with '-' or contain '.'");
			return;
		}
		
		String filename = basename + ".txt";
		try {
			PrintWriter file = new PrintWriter(filename);
			file.print(out);
			file.close();
		}
		catch (FileNotFoundException e) {
		}
	}
	
	public boolean contains(String val) {
		return indexOf(val) >= 0;
	}
	
	// gets the string after val
	public String valueAfter(String val) {
		int index = indexOf(val);
		return this.args[index + 1];
	}	
	
	// gets index of val
	public int indexOf(String val) {
		for (int i = 0; i < this.args.length; i++) {
			if (this.args[i].equals(val))
				return i;
		}
		
		// if argv does not contain val, then return -1
		return -1;
	}
}



