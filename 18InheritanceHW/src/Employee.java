
public class Employee extends Person {
	private final int MINIMUM_AGE = 18;
	private final int NORMAL_WORKING_HOURS_PER_DAY = 8;
	
	private double daySalary;
	
	public Employee(String name, int age, boolean isMale, double daySalary) {
		super(name, age, isMale);
		setDaySalary(daySalary);
	}
	
	public double calculateOvertime(double hours) {
		double overtimePay = 0;
		double hourlyRate = this.daySalary / NORMAL_WORKING_HOURS_PER_DAY;
		if (this.getAge() < MINIMUM_AGE) {
			overtimePay = 0;
		}
		else {
			overtimePay = hours * (hourlyRate * 1.5);
		}
		return overtimePay;
	}
	
	public void showEmployeeInfo() {
		super.showPersonInfo();
		System.out.println("Day salary: " + this.daySalary);
	}
	
	public double getDaySalary() {
		return this.daySalary;
	}
	
	public void setDaySalary(double daySalary) {
		if (daySalary < 0) {
			throw new IllegalArgumentException("Day salary can not be negative!");
		}
		this.daySalary = daySalary;
	}
}
