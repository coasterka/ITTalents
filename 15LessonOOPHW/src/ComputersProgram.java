
public class ComputersProgram {
	public static void main(String[] args) {
		Computer c1 = new Computer(2014, 1699.99, 8096, 2191, "Windows 7 Pro");
		Computer c2 = new Computer(2015, 2199.99, 12288, 8770, "Windows 10");
		c2.isNotebook = true;
		c2.useMemory(100);
		c1.changeOperationSystem("Windows 8.1");
		System.out.println("C1: " + c1);
		System.out.println("C2: " + c2);
		c2.useMemory(9300);
	}
}
