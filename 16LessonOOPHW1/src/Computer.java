
public class Computer {
	private int year;
	private double price;
	private boolean isNotebook;
	private double hardDiskMemory;
	private double freeMemory;
	private String operationSystem;

	public Computer() {
		this.isNotebook = false;
		this.operationSystem = "Win XP";
	}
	
	public Computer(int year, double price, double HDMemory, double freeMemory) {
		this();
		if (year <= 1950) {
			throw new IllegalArgumentException("Year must be at least 1950!");
		}
		if (price < 0) {
			throw new IllegalArgumentException("Price can not be negative!");
		}
		if (HDMemory < 0) { // 0 in case the computer is being sold without a HDD
			throw new IllegalArgumentException("Hard disk memory can not be negative!");
		}
		if (freeMemory < 0 || freeMemory > HDMemory) {
			throw new IllegalArgumentException("Free memory must be positive and smaller than the" +
					" HD memory!");
		}
		this.year = year;
		this.price = price;
		this.hardDiskMemory = HDMemory;
		this.freeMemory = freeMemory;
	}
	
	public Computer(int year, double price, boolean isNotebook, double HDMemory,
			double freeMemory, String operationSystem) {
		this(year, price, HDMemory, freeMemory);
		if (operationSystem == null || operationSystem.isEmpty()) {
			throw new IllegalArgumentException("Operation system can not be null or empty!");
		}
		this.isNotebook = isNotebook;
		this.operationSystem = operationSystem;
	}
	
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int comparePrice(Computer c) {
		int result = 0;
		if (this.price > c.price) {
			result = -1;
		}
		else if (this.price < c.price) {
			result = 1;
		}
		else {
			result = 0;
		}
		return result;
	}
	
	public void changeOperationSystem(String newOperationSystem) {
		if (newOperationSystem == null || newOperationSystem.isEmpty()) {
			throw new IllegalArgumentException("New operation system can not be null or empty!");
		}
		this.operationSystem = newOperationSystem;
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