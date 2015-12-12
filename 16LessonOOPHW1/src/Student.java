
public class Student {
	String name;
	private String subject;
	private double grade;
	private int yearInCollege;
	private int age;
	private boolean isDegree;
	private double money;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSubject() {
		return this.subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public double getGrade() {
		return this.grade;
	}
	
	public void setGrade(double grade) {
		if (grade > 6 || grade < 2) {
			throw new IllegalArgumentException("Invalid grade! Must be in range [2.. 6]!");
		}
		else {
			this.grade = grade;
		}
	}
	
	public int getYearInCollege() {
		return this.yearInCollege;
	}
	
	public void setYearInCollege(int yearInCollege) {
		this.yearInCollege = yearInCollege;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getMoney() {
		return this.money;
	}
	
	public Student() {
		this.grade = 4.0;
		this.yearInCollege = 1;
		this.isDegree = false;
		this.money = 0;
	}
	
	public Student(String name, String subject, int age) {
		this();
		if (name.isEmpty() || name.equals(null)) {
			throw new IllegalArgumentException("Name can not be null!");
		}
		else {
			this.name = name;
		}
		if (subject.isEmpty() || subject.equals(null)) {
			throw new IllegalArgumentException("Subject can not be null!");
		}
		else {
			this.subject = subject;
		}
		if (age < 16) {
			throw new IllegalArgumentException("All students must be at least 16 years old!");
		}
		else {
			this.age = age;
		}
	}
	
	public void upYear() {
		if (this.isDegree) {
			System.out.println("The student already has a degree!");
			return;
		}
		else {
			if (this.yearInCollege >= 4) {
				this.isDegree = true;
				System.out.println("The student has just graduated!");
			}
			else {
				this.yearInCollege++;
			}
		}		
	}
	
	public double receiveScholarship(double min, double amount) {
		if (min < 0 || min > 6) {
			throw new IllegalArgumentException("Minimum grade must be in range [2.. 6]!");
		}
		if (amount < 0) {
			throw new IllegalArgumentException("Money amount can not be negative!");
		}
		if (this.age == 0) {
			throw new IllegalArgumentException("Student's age is not defined!");
		}
		if (this.grade < min) {
			System.out.println("Student's grades are not high enough for a scholarship!");
			return 0;
		}
		if (this.age < 30 && this.grade >= min) {
			this.money += amount;
		}
		return this.money;
	}
}
