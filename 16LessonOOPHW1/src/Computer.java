
public class Computer {
	private int year;
	private double price;
	private boolean isNotebook;
	private double hardDiskMemory;
	private double freeMemory;
	private String operationSystem;
	
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Computer() {
		this.isNotebook = false;
		this.operationSystem = "Win XP";
	}
	
	public Computer(int year, double price, double HDMemory, double freeMemory) {
		this();
		this.year = year;
		this.price = price;
		this.hardDiskMemory = HDMemory;
		this.freeMemory = freeMemory;
	}
	
	public Computer(int year, double price, boolean isNotebook, double HDMemory,
			double freeMemory, String operationSystem) {
		this.year = year;
		this.price = price;
		this.isNotebook = isNotebook;
		this.hardDiskMemory = HDMemory;
		this.freeMemory = freeMemory;
		this.operationSystem = operationSystem;
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
	
	public int comparePrice(Computer comp) {
		int result = 0;
		if (this.price > comp.price) {
			result = -1;
		}
		else if (this.price < comp.price) {
			result = 1;
		}
		else {
			result = 0;
		}
		return result;
	}
	
	public void useMemory(double memory) {
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