
public class Task {
	private String name;
	private double workingHours;	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getWorkingHours() {
		return this.workingHours;
	}
	
	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}
	
	public Task(String name, double workingHours) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Task's name can not be empty!");
		}
		else {
			this.name = name;
		}
		if (workingHours <= 0) {
			throw new IllegalArgumentException("Working hours can not be negative or = 0!");
		}
		else {
			this.workingHours = workingHours;
		}
	}
}