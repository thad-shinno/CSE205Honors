import java.net.Socket;

public class PortScan {
	public static void main(String[] args) {
		final int NUM_PORTS = 65535;
		String ip = args[0]
		
		Socket s;
		for (int i = 1; i <= NUM_PORTS; i++) {
			try {
				s = new Socket(ip, i);
				System.out.println("Port open: " + i);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}