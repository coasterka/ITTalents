public class Employee {
	
	private String name;
	private Task currentTask;
	private double hoursLeft;	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Employee's name can not be empty!");
		}
		else {
			this.name = name;
		}
	}
	
	public Task getCurrentTask() {
		return this.currentTask;
	}
	
	public void setCurrentTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Task is not defined!");
		}
		else {
			this.currentTask = task;
		}
	}
	
	public double getHoursLeft() {
		return this.hoursLeft;
	}
	
	public void setHoursLeft(double hoursLeft) {
		if (hoursLeft <= 0) {
			throw new IllegalArgumentException("Hours left can not be negative or = 0!");
		}
		else {
			this.hoursLeft = hoursLeft;
		}
	}
	
	public Employee(String name) {
		this.setName(name);
	}
	
	public void work() {
		if (this.currentTask == null) {
			System.out.println("Employee doesn't have a current task.");
			return;
		}
		if (this.hoursLeft <= 0) {
			System.out.println("Employee doesn't have any hours left for today.");
			return;
		}
		if (this.currentTask.getWorkingHours() <= 0) {
			System.out.println("Task is already finished.");
			return;
		}
		double taskHours = this.currentTask.getWorkingHours();
		double employeeHours = this.hoursLeft;
		if (taskHours > employeeHours) {
			taskHours -= employeeHours;
			employeeHours = 0;
		}
		else if (employeeHours > taskHours) {
			employeeHours -= taskHours;
			taskHours = 0;
		}
		else {
			employeeHours = 0;
			taskHours = 0;
		}
		this.currentTask.setWorkingHours(taskHours);
		this.hoursLeft = employeeHours;
		showReport();
	}
	
	public void showReport() {
		String report = "Employee name: " + this.name + ", Task name: " + this.currentTask.getName() +
				"\nEmployee hours left: " + this.hoursLeft + ", Task hours left: " +
				this.currentTask.getWorkingHours();
		System.out.println(report);
	}	
}