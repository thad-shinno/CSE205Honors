public class OptionArray {
	private String[] args;
	
	// help message
	private String help = "Usage: java PortScan [options] [ip]\n"
						+ "OPTIONS:\n"
						+ "\t -o [basename]: Output to [basename].txt\n"
						+ "\t -c: only scan the 20 most common ports"
						+ "\t -h: Print this help summary page\n"
						+ "EXAMPLE:\n"
						+ "java PortScan -c -o openports 168.92.0.1\n"
						+ "\t (this scans the 20 most common ports on the ip address 168.92.0.1 and saves to an output called openports.txt)";
	
	// default constructor
	public OptionArray() {
		this.args = null;
	}
	
	// an option array contains a length and values
	public OptionArray(String[] args) {
		this.args = args;
	}
	
	// gets index of val
	public int indexOf(String val) {
		for (int i = 0; i < this.args.length; i++) {
			if (this.args[i].equals(val))
				return i;
		}
		
		// if argv does not contain val, then return -1
		return -1;
	}
	
	public boolean Contains(String val) {
		return indexOf(val) >= 0;
	}
	
	// gets the string after val
	public String valueAfter(String val) {
		int index = indexOf(val);
		return this.args[index + 1];
	}
	
	// displays help message if necessary
	public boolean checkOptions() {
		// check if there are any options at all
		if (args.length < 1) {
			System.out.println(help);
			return false;
		}
		
		// pring the help message
		if (Contains("-h") || Contains("--help") || Contains("-help") || Contains("help") ) {
			System.out.println(help);
			return false;
		}
		
		// has options and doesn't need help
		return true;
	}
}



