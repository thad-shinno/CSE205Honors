// a port has a name and number
public class Port {
	private int num;
	private String name;
	
	Port() {
		this.num = 0;
		this.name = "";
	}
	
	Port(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public String getName() {
		return this.name;
	}
}