public class Employee {
	
	private String name;
	private Task currentTask;
	private double hoursLeft;
	private AllWork allWork;
	
	public Employee(String name) {
		setName(name);
		startWorkingDay();
	}
	
	public void startWorkingDay() {
		setHoursLeft(8);
		System.out.println("Employee " + this.name + " started a new working day.");		
	}
	
	public void work() throws Exception {
		if (!allWork.isAllWorkDone()) {
		double taskHours = this.currentTask.getWorkingHours();
		double employeeHours = this.hoursLeft;
		if (employeeHours <= 0) {
			this.startWorkingDay();
		}
		if (this.currentTask == null || this.currentTask.getWorkingHours() <= 0) {
			this.currentTask = allWork.getNextTask();
			System.out.println(this.name + " took the task " + this.currentTask.getName());
		}
		if (taskHours < employeeHours) {
			this.hoursLeft -= taskHours;
			taskHours = 0;			
			this.currentTask.setWorkingHours(taskHours);
			System.out.println("Task " + this.currentTask.getName() + " is finished");
			
			//System.out.println("Employee " + this.name + " hours left: " + this.hoursLeft);
			if (!allWork.isAllWorkDone()) {
				this.currentTask = allWork.getNextTask();
				this.currentTask.setEmployee(this);
			}
			System.out.println("Employee " + this.name + " took Task " + this.currentTask.getName());
		}
		else if (taskHours > employeeHours) {
			taskHours -= this.hoursLeft;
			this.currentTask.setWorkingHours(taskHours);
			employeeHours = 0;
			this.hoursLeft = employeeHours;
			System.out.println(this.name + " doesn't have any hours left for today.");
			this.startWorkingDay();
		}
		else {
			this.startWorkingDay();
			this.currentTask = allWork.getNextTask();
			this.currentTask.setEmployee(this);
			System.out.println("Employee " + this.name + " took Task: " + this.currentTask.getName());
		}
		System.out.println("Employee " + this.name + " hours left: " + employeeHours);
		System.out.println("Task " + this.currentTask.getName() + " hours left: " + this.currentTask.getWorkingHours());
		//showReport();
		}
	}
	
	public void showReport() {
		String report = "Employee name: " + this.name + ", Task name: " + this.currentTask.getName() +
				"\nEmployee hours left: " + this.hoursLeft + ", Task hours left: " +
				this.currentTask.getWorkingHours();
		System.out.println(report);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Employee's name can not be null or empty!");
		}
		this.name = name;
	}
	
	public Task getCurrentTask() {
		return this.currentTask;
	}
	
	public void setCurrentTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Task is not defined!");
		}
		this.currentTask = task;
		task.setEmployee(this);
		System.out.println("Employee " + this.name + " working on task: " + task.getName());
		System.out.println("Task " + task.getName() + " hours left: " + task.getWorkingHours());
	}
	
	public double getHoursLeft() {
		return this.hoursLeft;
	}
	
	public void setHoursLeft(double hoursLeft) {
		if (hoursLeft <= 0) {
			startWorkingDay();
		}
		this.hoursLeft = hoursLeft;
	}
	
	public AllWork getAllWork() {
		return this.allWork;
	}
	
	public void setAllWork(AllWork allWork) {
		if (allWork == null) {
			throw new IllegalArgumentException("All work is not defined!");
		}
		this.allWork = allWork;
	}
}