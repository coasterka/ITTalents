
public class Person {
	private String name;
	private int age;
	private boolean isMale;
	
	public Person(String name, int age, boolean isMale) {
		setName(name);
		setAge(age);
		this.isMale = isMale;
	}
	
	public void showPersonInfo() {
		String personInfo = "";
		personInfo += "Name: " + this.getName() + "\nAge: " + this.getAge() +
				"\nMale: " + this.isMale();
		System.out.println(personInfo);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Person name can not be null or empty!");
		}
		this.name = name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		if (age < 0 || age > 120) {
			throw new IllegalArgumentException("Invalid person age! Must be in range [0.. 120]!");
		}
		this.age = age;
	}
	
	public boolean isMale() {
		return this.isMale;
	}
}
