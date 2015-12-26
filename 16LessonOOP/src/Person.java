public class Person {
	
	private String name;
	private int age;
	private double weight;
	private long personalNumber;
	private boolean isMale;
	private Person[] friends;
	private double money = 0;
	private Car car;

	public Person() {
		setAge(0);
		this.weight = 4.0;
	}
	
	public Person(String name, int age) {
		setName(name);
		setAge(age);
	}
	
	public Person(String name, long personalNumber, boolean isMale) {
		this();
		this.name = name;
		this.personalNumber = personalNumber;
		this.isMale = isMale;
		this.friends = new Person[3];
	}
	
	public void eat() {
		System.out.println(this.name + " is eating.");
	}
	
	public void walk() {
		System.out.println(this.name + " is walking.");
	}
	
	public void growUp() {
		this.age++;
		System.out.println(this.name + "'s age is " + this.age + ".");
	}
	
	public void drinkWater(double liters) {
		System.out.println(this.name + " drinks " + liters + " liters of water.");
	}
	
	public void addFriend(Person friend) {
		for (int i = 0; i < friends.length; i++) {
			if (this.friends[i] == null) {
				this.friends[i] = friend;
				break;
			}
		}
	}
	
	public void buyCar(Car car) {
		if (car == null) {
			throw new IllegalArgumentException("Car is not defined!");
		}
		if (car.getPrice() == 0) {
			throw new IllegalArgumentException("Car's price is not defined!");
		}
		if (this.money < car.getPrice()) {
			System.out.println("Buyer is a poor bastard!");
		}
		else {
			this.money -= car.getPrice();
			if (car.getOwner() != null) {
				car.getOwner().setCar(null);
			}
			car.setOwner(this);
			this.setCar(car);
		}
	}
	
	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		if (money < 0) {
			throw new IllegalArgumentException("Person money can not be negative!");
		}
		this.money = money;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		if (car == null) {
			throw new IllegalArgumentException("Car is not defined!");
		}
		this.car = car;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name can not be null or empty!");
		}
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		if (age < 0 || age > 120) {
			throw new IllegalArgumentException("Invalid age! Must be in range [0.. 120]!");
		}
		this.age = age;
	}

	public double getWeight() {
		return this.weight;
	}

	public long getPersonalNumber() {
		return this.personalNumber;
	}

	public boolean isMale() {
		return this.isMale;
	}

	public Person[] getFriends() {
		return this.friends;
	}
	
	@Override public String toString() {
		String s = "{Name: " + this.name + ", Age: " + this.age + "}";
		return s;
	}
}