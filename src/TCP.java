/**
 * CSE 205: 11333 / T TH 4:30pm
 * Honors Project
 * Author: Thaddeus Shinno & 1216639502
 * Descripion: Class that scans ports
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
		String scanned;
		// loop and scan each port
		for (int i = 1; i <= 65535; i++) {
			scanned = scan(ip, i);
			// if the port is open, print the port info
			if (scanned.length() > 0) {
				System.out.println(scanned);
				out += scanned + "\n";
			}
		}
		return out;
	}
	
	/**
	 * Only scan the 20 most common ports
	 */
	 public static String scanCommon(String ip) {
		String out = "";
		String scanned;
		Port[] commonPorts = getCommonPorts();
		// loop and scan each port in commonPorts array
		for (int i = 0; i < commonPorts.length; i++) {
			scanned = scan(ip, commonPorts[i].num, commonPorts[i].name);
			// if connection was successful, then print out the port info
			if (scanned.length() > 0) {
				System.out.println(scanned);
				out += scanned + "\n";
			}
			
		}
		return out;
	 }
	
	
	/**
	 * Scan a port num on an ip address
	 */
	public static String scan(String ip, int num) {
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
	
	/**
	 * Scan a port num on an ip address and append the name if given.
	 */
	public static String scan(String ip, int num, String name) {
		// Scan a port num on an ip address
		String out = scan(ip, num);
		// append the name if scan was successful and name was given
		if (out.length() > 0 && name.length() > 0) {
			out += String.format(" (%s)", name);
		}
		// returns an empty string if connection failed
		return out;
	}
	
	/**
	 * Return an array of the 20 most common ports as given in common_ports.txt
	 */
	public static Port[] getCommonPorts() {
		try {
			// initialize array of only the 20 most common ports
			Port[] portList = new Port[20];
			
			// read common_ports.txt
			File common_ports = new File("common_ports.txt");
			Scanner in = new Scanner(common_ports);
			
			// create new TCP object to access local subclass port
			TCP list = new TCP();
			// fill the array of ports with common ports
			for (int i = 0; in.hasNext(); i++) {
				portList[i] = list.new Port(in.nextInt(), in.next());;
			}
			in.close();
			return portList;
		}
		catch (FileNotFoundException e) {
			return null;
		}
	}
	
	class Port {
		private int num;
		private String name;
		
		Port() {
			this.num = 0;
			this.name = "";
		}
		
		Port(int num, String name) {
			this.num = num;
			this.name = name;
		}
	}

}