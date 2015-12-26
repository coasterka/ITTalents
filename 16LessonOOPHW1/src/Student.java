
public class Student {
	String name;
	private String subject;
	private double grade;
	private int yearInCollege;
	private int age;
	private boolean isDegree;
	private double money;
	
	public Student() {
		setGrade(4.0);
		setYearInCollege(1);
		this.isDegree = false;
		setMoney(0);
	}
	
	public Student(String name, String subject, int age) {
		this();
		setName(name);
		setSubject(subject);
		setAge(age);
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
		if (min < 2 || min > 6) {
			throw new IllegalArgumentException("Invalid minimum grade! Must be in range [2.. 6]!");
		}
		if (amount <= 0) {
			throw new IllegalArgumentException("Money amount can not be negative or = 0!");
		}
		if (this.age == 0) {
			throw new IllegalArgumentException("Student's age is not defined!");
		}
		if (this.grade < min) {
			System.out.println("Student's grades are not high enough for this scholarship!");
			return 0;
		}
		if (this.age < 30 && this.grade >= min) {
			this.money += amount;
		}
		return this.money;
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
	
	public String getSubject() {
		return this.subject;
	}
	
	public void setSubject(String subject) {
		if (subject == null || subject.isEmpty()) {
			throw new IllegalArgumentException("Subject can not be null or empty!");
		}
		this.subject = subject;
	}
	
	public double getGrade() {
		return this.grade;
	}
	
	public void setGrade(double grade) {
		if (grade > 6 || grade < 2) {
			throw new IllegalArgumentException("Invalid grade! Must be in range [2.. 6]!");
		}
		this.grade = grade;
	}
	
	public int getYearInCollege() {
		return this.yearInCollege;
	}
	
	public void setYearInCollege(int yearInCollege) {
		if (yearInCollege < 1 || yearInCollege > 4) {
			throw new IllegalArgumentException("Invalid college year! Must be in range [1.. 4]!");
		}
		this.yearInCollege = yearInCollege;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		if (age < 16 || age > 99) {
			throw new IllegalArgumentException("Invalid age! Must be in range [16.. 99]!");
		}
		this.age = age;
	}
	
	public double getMoney() {
		return this.money;
	}
	
	public void setMoney(double money) {
		if (money < 0) {
			throw new IllegalArgumentException("Money can not be negative!");
		}
		this.money = 0;
	}
}
