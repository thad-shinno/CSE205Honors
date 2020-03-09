import java.net.Socket;
import java.io.*;

public class PortScan {
	public static void main(String[] args) {
		OptionArray options = new OptionArray(args);
		// check if user needs help
		if (!options.checkOptions()) {
			return;
		}
		
		String ip = args[args.length - 1];
		
		// scan most common ports
		if (options.Contains("-c")) {	
			TCP.scanCommon(ip);
		}
		// scan all ports
		else {
			TCP.scanAll(ip);
		}
	}
}