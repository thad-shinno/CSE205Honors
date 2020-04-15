/**
 * CSE 205: 11333 / T TH 4:30pm
 * Honors Project
 * Author: Thaddeus Shinno & 1216639502
 * Descripion: Main method for the Port Scanner
 */

/**
 * Call OptionArray class to manage user input and make output.
 * Call TCP class to scan ports
 */
public class PortScan {
	public static void main(String[] args) {
		// check if user needs help
		OptionArray options = new OptionArray(args);
		if (!options.checkOptions()) {
			return;
		}
		
		// ip is the last argument
		String ip = args[args.length - 1];
		
		// create output text file content
		String out = "java PortScan" + options.getArgs();
		
		// scan most common ports
		if (options.contains("-c")) {	
			out += TCP.scanCommon(ip);
		}
		// scan all ports
		else {
			out += TCP.scanAll(ip);
		}
		
		// make output .txt file
		if (options.contains("-o")) {
			OptionArray.save(out, options.valueAfter("-o"));
		}
	}
}