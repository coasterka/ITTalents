
public class Task {
	private String name;
	private double workingHours;
	private Employee employee;
	
	public Task(String name, double workingHours) {
		setName(name);
		setWorkingHours(workingHours);
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
	
	public void setEmployee(Employee employee) {
		if (employee == null) {
			throw new IllegalArgumentException("Employee is not defined!");
		}
		//employee.setCurrentTask(this);
		this.employee = employee;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Task name can not be null or empty!");
		}
		this.name = name;
	}
	
	public double getWorkingHours() {
		return this.workingHours;
	}
	
	public void setWorkingHours(double workingHours) {
		if (workingHours < 0) { // 0 in case the task is already finished
			workingHours = 0;
		}
		this.workingHours = workingHours;
	}
}