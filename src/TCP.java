/**
 * TCPPortHelper
 */
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class TCP {
	/** 		
	 * Scan ALL 65535 ports and return output
	 */
	public static String scanAll(String ip) {
		String out = "";
		String scan;
		// loop and scan each port
		for (int i = 1; i <= 65535; i++) {
			scan = Scan(ip, i);
			// if the port is open, print the port info
			if (scan.length() > 0) {
				System.out.println(scan);
				out += scan + "\n";
			}
		}
		return out;
	}
	
	/**
	 * Only scan the 20 most common ports
	 */
	 public static String scanCommon(String ip) {
		String out = "";
		String scan;
		Port[] commonPorts = getCommonPorts();
		// loop and scan each port in commonPorts array
		for (int i = 0; i < commonPorts.length; i++) {
			scan = TCP.Scan(ip, commonPorts[i].getNum(), commonPorts[i].getName());
			// if connection was successful, then print out the port info
			if (scan.length() > 0) {
				System.out.println(scan);
				out += scan + "\n";
			}
			
		}
		return out;
	 }
	
	/**
	 * Outputs string to a file
	 */
	public static void Save(String out, String basename) {
		String filename = basename + ".txt";
		try {
			PrintWriter file = new PrintWriter(filename);
			file.print(out);
			file.close();
		}
		catch (FileNotFoundException e) {
		}
	}
	
	// scan a port num on an ip
	public static String Scan(String ip, int num) {
		try {
			// return a string of the open port number
			Socket s = new Socket(ip, num);
			return String.format("Port Open: %d", num);
		}
		catch (Exception e) {
			// return an empty string if connection failed
			return "";
		}
	}
	
	// scan an ip's port num and print the name if given
	public static String Scan(String ip, int num, String name) {
		String out = TCP.Scan(ip, num);
		if (out.length() > 0) {
			out += String.format(" (%s)", name);
		}
		// returns an empty string if connection failed
		return out;
	}
	
	// returns an array of the 20 most common ports
	public static Port[] getCommonPorts() {
		 // create an array of ports
		try {
			Port[] portList = new Port[20]; // only the 20 most common ports
			
			// fill the array of ports
			File common_ports = new File("common_ports.txt");
			Scanner in = new Scanner(common_ports);
			
			Port port;
			for (int i = 0; in.hasNext(); i++) {
				portList[i] = new Port(in.nextInt(), in.next());;
			}
			in.close();
			return portList;
		}
		catch (FileNotFoundException e) {
			return null;
		}
	}

}