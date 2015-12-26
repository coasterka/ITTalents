public class Car {
	
	private String model;
	private int maxSpeed;
	private int currentSpeed;
	private Color color;
	private char currentGear;
	private Person owner;
	private double price = 0;
	private boolean isSportCar = false;
	
	public Car() { }

	public Car(String model, Color color) {
		setModel(model);
		setColor(color);
	}
	
	public Car(String model, boolean isSportCar, Color color, double price) {
		this(model, color);
		this.isSportCar = isSportCar;
		setPrice(price);
	}
	
	public Car(String model, int maxSpeed, int currentSpeed, Color color, char currentGear) {
		this(model, color);
		setMaxSpeed(maxSpeed);
		setCurrentSpeed(currentSpeed);
		setCurrentGear(currentGear);
	}
	
	public static void printDetailsFor(Car car){
		StringBuilder sb = new StringBuilder();
		sb.append("Model: " + car.model + "\n");
		sb.append("Max speed: " + car.maxSpeed + "\n");
		sb.append("Owner: " + car.owner);
		System.out.println(sb);
	}
	
	public void accelerate() {
		if (this.currentSpeed * 2 > this.maxSpeed) {
			System.out.println("Car can not accelerate. Value is bigger than its max speed.");
		}
		else {
			this.currentSpeed *= 2;
			System.out.println(this.currentSpeed);
		}
	}
	
	public void changeGearUp() {
		if ((this.currentGear + 1) < '0' || (this.currentGear + 1) > '6') {
			System.out.println("Not a valid value.");
			return;
		}
		else {
			this.currentGear++;
			System.out.println(this.currentGear);
		}
	}
	
	public void changeGearDown() {
		if ((this.currentGear - 1) < '0' || (this.currentGear - 1) > '6') {
			System.out.println("Not a valid value.");
			return;
		}
		else {
			this.currentGear--;
			System.out.println(this.currentGear);
		}
	}
	
	public void changeGear(char nextGear) {
		// validation can be moved in setter
		if (nextGear > '0' && nextGear < '6') {
			this.currentGear = nextGear;
		}
		else {
			System.out.println("Not a valid value.");
			return;
		}
	}
	
	public void changeColor(Color newColor) {
		this.setColor(newColor);
	}
	
	public boolean isMoreExpensive(Car car) {
		if (car == null || this == null) {
			throw new IllegalArgumentException("Both cars must be created before using the method!");
		}
		else {
			boolean isMoreExpensive = 
					(this.price > car.price) ? true : false;
			return isMoreExpensive;
		}
	}
	
	public double calculateCarPriceForScrap(double metalPrice) {
		if (metalPrice <= 0) {
			throw new IllegalArgumentException("Metal price can not be negative or = 0!");
		}
		if (this.color == null) {
			throw new IllegalArgumentException("Color is not defined!");
		}
		double coef = 0.2;
		if (this.color == Color.BLACK || this.color == Color.WHITE) {
			coef += 0.05;
		}
		if (this.isSportCar) {
			coef += 0.05;
		}
		double price = metalPrice * coef;
		return price;
	}
	
	public void changeOwner(Person newOwner) {
		if (this.owner == null) {
			throw new IllegalArgumentException("The car doesn't have an owner!");
		}
		this.setOwner(newOwner); // validation for newOwner is in setter
	}
	
	public double sellCarForScrap(double metalPrice) {
		if (metalPrice <= 0) {
			throw new IllegalArgumentException("Metal price can not be negative or = 0!");
		}
		double remainingMoney = this.getOwner().getMoney() +
				this.calculateCarPriceForScrap(metalPrice);
		this.setOwner(null);
		return remainingMoney;
	}
	
	@Override public String toString() {
		String s = "";
		s += "Model: " + this.getModel() + ", Sport: " + this.isSportCar() +
				", Color: " + this.getColor();
		return s;
	}
	
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		if (model == null || model.isEmpty()) {
			throw new IllegalArgumentException("Model can not be null or empty!");
		}
		this.model = model;
	}

	public int getMaxSpeed() {
		return this.maxSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		if (maxSpeed < 0) {
			throw new IllegalArgumentException("Max speed can not be negative!"); // equal to 0 when car is broken?
		}
		this.maxSpeed = maxSpeed;
	}

	public int getCurrentSpeed() {
		return this.currentSpeed;
	}
	
	public void setCurrentSpeed(int currentSpeed) {
		if (currentSpeed < 0) {
			throw new IllegalArgumentException("Current speed can not be negative!");
		}
		this.currentSpeed = currentSpeed;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		if (color == null) {
			throw new IllegalArgumentException("Color is not defined!");
		}
		this.color = color;
	}

	public char getCurrentGear() {
		return this.currentGear;
	}
	
	public void setCurrentGear(char currentGear) {
		if (currentGear < '0' || currentGear > '6') {
			throw new IllegalArgumentException("Invalid current gear! Must be char in range [1.. 5]!");
		}
		this.currentGear = currentGear;
	}

	public Person getOwner() {
		return this.owner;
	}

	public void setOwner(Person owner) {
		if (owner == null) {
			throw new IllegalArgumentException("Owner is not defined!");
		}
		this.owner = owner;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		if (price < 0) {
			throw new IllegalArgumentException("Price can not be negative!");
		}
		this.price = price;
	}

	public boolean isSportCar() {
		return this.isSportCar;
	}

	public void setSportCar(boolean isSportCar) {
		this.isSportCar = isSportCar;
	}
}