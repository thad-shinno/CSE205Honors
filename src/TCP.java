/**
 * TCPPortHelper
 */
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class TCP {
	// scan an ip's port num
<<<<<<< HEAD
	public static void Scan(String ip, int num) {
		try {
			Socket s = new Socket(ip, num);
			System.out.print("Port Open: " + num);
		}
		catch (Exception e) {
=======
	public static String Scan(String ip, int num) {
		try {
			Socket s = new Socket(ip, num);
			return "Port Open: " + num;
		}
		catch (Exception e) {
			return null;
>>>>>>> a2ef5e715bc1ec1496768e6a3d312eb37a337794
		}
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