/**
 * CSE 205: 11333 / T TH 4:30pm
 * Honors Project
 * Author: Thaddeus Shinno & 1216639502
 * Descripion: Class that manages user input and displays help menu
 */

import java.io.*;

public class OptionArray {
	// the user's input is called args
	private String[] args;
	
	// help message
	private String help = "Usage: java Main [options] [ip]\n"
						+ "OPTIONS:\n"
						+ "\t -o [basename]: Output to [basename].txt\n"
						+ "\t -c: only scan the 20 most common ports\n"
						+ "\t -h: Print this help summary page\n"
						+ "EXAMPLE:\n"
						+ "java Main -c -o openports 168.92.0.1\n"
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
	 * returns back the user's input arguments with spaces
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
	 * Outputs string to a file called [basename].txt
	 */
	public static void save(String out, String basename) {
		// if the basename begins with a '-' or contains '.' then return with a basename prompt
		// this is to avoid confusion with arguments and filetypes
		if (basename.charAt(0) == '-' || basename.contains(".")) {
			System.out.println("***Could not output text file. Basename must not begin with '-' and cannot contain '.'");
			return;
		}
		
		String filename = basename + ".txt";
		try {
			// create the file
			PrintWriter file = new PrintWriter(filename);
			file.print(out);
			file.close();
		}
		catch (FileNotFoundException e) {
		}
	}
	
	/**
	 * Check if args contains a string.
	 */
	public boolean contains(String val) {
		return indexOf(val) >= 0;
	}
	
	/**
	 * returns the string AFTER val
	 */ 
	public String valueAfter(String val) {
		// Index will always exist since in the main method, it is checked if val is contained.
		int index = indexOf(val);
		return this.args[index + 1];
	}	
	
	/**
	 * gets index of String val in an array
	 */
	private int indexOf(String val) {
		for (int i = 0; i < this.args.length; i++) {
			if (this.args[i].equals(val))
				return i;
		}
		
		// if argv does not contain val, then return -1
		return -1;
	}
}



