
public class Computer {
	private int year;
	private double price;
	public boolean isNotebook;
	private int hardDiskMemory;
	private int freeMemory;
	private String operationSystem;
	
	public Computer(int year, double price, int HDMemory, int freeMemory, String OS) {
		this.year = year;
		this.price = price;
		this.hardDiskMemory = HDMemory;
		this.freeMemory = freeMemory;
		this.operationSystem = OS;
	}
	
	public void changeOperationSystem(String newOperationSystem) {
		if (newOperationSystem.isEmpty() || newOperationSystem == null) {
			System.out.println("Invalid value!");
			return;
		}
		else {
			this.operationSystem = newOperationSystem;
		}
	}
	
	public void useMemory(int memory) {
		if (memory > this.freeMemory) {
			System.out.println("Not enough free memory!");
			return;
		}
		else {
			this.freeMemory -= memory;
		}
	}
	
	@Override public String toString() {
		String s = "Year: " + this.year + ", Price: " + this.price + ", Notebook: " + this.isNotebook +
				", HD Memory: " + this.hardDiskMemory + ", Free memory: " + this.freeMemory +
				", OS: " + this.operationSystem;
		return s;
	}
}