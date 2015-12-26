public class TV {
	
	private double screenSize;
	private double weight;
	private double price;
	private Color color;
	private Brand brand;
	private int quantity;
	
	public TV(double screenSize, double weight, double price, Color color, Brand brand, int quantity) {
		this.screenSize = screenSize;
		this.weight = weight;
		this.price = price;
		this.color = color;
		this.brand = brand;
		this.quantity = quantity;
	}
	
	public double getScreenSize() {
		return this.screenSize;
	}
	
	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public static void sell(TV tv, int quantity) {
		if (tv.quantity < 1) {
			System.out.println("Enter a valid quantity!");
		}
		else {
			tv.quantity -= quantity;
		}		
	}
	
	public static void order(TV tv, int quantity) {
		if (tv.quantity < 1) {
			System.out.println("Enter a valid quantity!");
		}
		else {
			tv.quantity += quantity;
		}
	}
	
	@Override public String toString() {
		String str = "";
		str += "\n{Screen size: " + this.screenSize + "\n";
		str += "Weight: " + this.weight + "\n";
		str += "Price: " + this.price + "\n";
		str += "Color: " + this.color + "\n";
		str += "Brand: " + this.brand + "\n";
		str += "Quantity: " + this.quantity + "}";
		return str;
	}
}