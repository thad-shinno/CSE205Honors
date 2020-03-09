import java.net.Socket;
import java.io.*;

public class PortScan {
	public static void main(String[] args) {
		OptionArray options = new OptionArray(args);
		// check if user needs help
		if (!options.checkOptions()) {
			return;
		}
		
		// ip is the last argument
		String ip = args[args.length - 1];
		
		// create output text file String
		String out = "java PortScan" + options.getArgs();
		
		// scan most common ports
		if (options.Contains("-c")) {	
			out += TCP.scanCommon(ip);
		}
		// scan all ports
		else {
			out += TCP.scanAll(ip);
		}
		
		if (options.Contains("-o")) {
			TCP.Save(out, options.valueAfter("-o"));
		}
	}
}