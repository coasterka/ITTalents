public class Dog extends Animal {
	
	private String owner;
	
	public Dog (String color, int age, double weight, String owner) {
		super(color, age, weight);
		this.owner = owner;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override public String toString() {
		String str = this.getColor() + " " + this.getAge() + " " + this.getWeight() + " " + this.getOwner();
		return str;
	}
}