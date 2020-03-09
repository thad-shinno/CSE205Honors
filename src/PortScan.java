import java.net.Socket;
import java.io.*;

public class PortScan {
	public static void main(String[] args) {
		OptionArray options = new OptionArray(args);
		// check if user needs help
		if (!options.checkOptions()) {
			return;
		}
		
		final int NUM_PORTS = 65535;
		String ip = args[args.length - 1];
		
		// init commonPorts and scan only the common ports
		// getCommonPorts has try catch FileNotFoundException
		Port[] commonPorts = TCP.getCommonPorts();
		
		// scan most common ports
		if (options.Contains("-c")) {	
			for (int i = 0; i < commonPorts.length; i++) {
				// Scan has try catch Exception
				String out = TCP.Scan(ip, commonPorts[i].getNum(), commonPorts[i].getName());
				// if connection was successful, then print out the port info
				if (out.length() > 0)
					System.out.println(out);
			}
		}
		
		// scan all ports
		else {
			for (int i = 1; i <= NUM_PORTS; i++) {
				String out = TCP.Scan(ip, i);
				if (out.length() > 0)
					System.out.println(out);
			}
		}
	}
}