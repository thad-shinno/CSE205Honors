/**
 * TCPPortHelper
 */
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class TCP {
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
				port = new Port(in.nextInt(), in.next());
				portList[i] = port;
			}
			in.close();
			return portList;
		}
		catch (FileNotFoundException e) {
			return null;
		}
	}

}