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
<<<<<<< HEAD
		String ip = args[args.length];
=======
		String ip = args[1];
>>>>>>> a2ef5e715bc1ec1496768e6a3d312eb37a337794
		
		// scan most common ports
		if (options.Contains("-c")) {
			// init commonPorts and scan only the common ports
			Port[] commonPorts = TCP.getCommonPorts(); // getCommonPorts has try catch FileNotFoundException
			for (int i = 0; i < commonPorts.length; i++) {
<<<<<<< HEAD
				TCP.Scan(ip, commonPorts[i].getNum())  // Scan has try catch Exception
				System.out.printf(" (%s)\n", commonPorts[i].getName());
=======
				System.out.printf("%s (%s)\n", TCP.Scan(ip, commonPorts[i].getNum()), commonPorts[i].getName()); // Scan has try catch Exception
>>>>>>> a2ef5e715bc1ec1496768e6a3d312eb37a337794
			}
		}
		
		// scan all ports
		else {
			for (int i = 1; i <= NUM_PORTS; i++) {
<<<<<<< HEAD
				TCP.Scan(ip, i);
=======
				System.out.println(TCP.Scan(ip, i));
>>>>>>> a2ef5e715bc1ec1496768e6a3d312eb37a337794
			}
		}
	}
}