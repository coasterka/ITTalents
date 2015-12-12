public class ComputerDemo {
	
	public static void main(String[] args) {
		Computer c1 = new Computer();
		Computer c2 = new Computer(2014, 890.00, 1000, 200);
		Computer c3 = new Computer(2015, 1900.00, true, 2000, 1800, "Debian");
		
		c1.setPrice(c3.getPrice());
		
		System.out.println(c2.comparePrice(c3)); // 1
		System.out.println(c1.comparePrice(c3)); // 0
		System.out.println(c3.comparePrice(c2)); // -1
	}
}
