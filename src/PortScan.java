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
		String ip = args[1];
		
		// scan most common ports
		if (options.Contains("-c")) {
			// init commonPorts and scan only the common ports
			Port[] commonPorts = TCP.getCommonPorts(); // getCommonPorts has try catch FileNotFoundException
			for (int i = 0; i < commonPorts.length; i++) {
				System.out.printf("%s (%s)\n", TCP.Scan(ip, commonPorts[i].getNum()), commonPorts[i].getName()); // Scan has try catch Exception
			}
		}
		
		// scan all ports
		else {
			for (int i = 1; i <= NUM_PORTS; i++) {
				System.out.println(TCP.Scan(ip, i));
			}
		}
	}
}