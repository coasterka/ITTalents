public class Animal {
	
	private String color;
	private int age;
	private double weight;
	
	public Animal(String color, int age, double weight) {
		this.color = color;
		this.age = age;
		this.weight = weight;
	}
	
	public String getColor() {
		return this.color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return this.weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}