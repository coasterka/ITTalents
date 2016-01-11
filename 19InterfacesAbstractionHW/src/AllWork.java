
public class AllWork {
	private Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask;
	
	public AllWork() throws Exception {
		this.tasks = new Task[10];
		this.freePlacesForTasks = tasks.length;
		setCurrentUnassignedTask(0);
	}
	
	public void addTask(Task task) throws Exception {
		if (task == null) {
			throw new IllegalArgumentException("Task is not defined!");
		}
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] == null) {
				tasks[i] = task;
				break;
			}
		}
	}
	
	public Task getNextTask() throws Exception {
		Task nextUnassignedTask = null;
		if (!isAllWorkDone()) {
			for (int i = 0; i < tasks.length; i++) {
				if (tasks[i] != null) {
					if (tasks[i].getEmployee() == null) {
						nextUnassignedTask = tasks[i];
						isAllWorkDone();
						break;
					}
				}
			}
			if (nextUnassignedTask == null) {
				throw new Exception("All tasks are assigned to employees!");
			}
		}
		return nextUnassignedTask;
	}
	
	public boolean isTaskFinished(Task task) {
		boolean isTaskFinished = false;
		if (task != null) {
			if (task.getWorkingHours() == 0) {
				isTaskFinished = true;
			}
		}
		return isTaskFinished;
	}
	
	public boolean isAllWorkDone() {
		boolean isAllWorkDone = false;
		short counter = 0;
		short counterTasks = 0;
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] != null) {
				if (isTaskFinished(tasks[i])) {
					counterTasks++;
				}
				if (tasks[i].getWorkingHours() > 0) {
					return isAllWorkDone;
					//System.out.println("There is still work to do");
				}
				else {
					counter++;
				}
			}
			else {
				break;
			}
		}
		if (counter == counterTasks) {
			isAllWorkDone = true;
			System.out.println("All work is done!");
			System.exit(0);
		}
		return isAllWorkDone;
	}
	
	public int getFreePlacesForTasks() throws Exception { // what exception?
		int freeTasksCount = 0;
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] == null) {
				freeTasksCount++;
			}
		}
		if (freeTasksCount < 0) {
			throw new Exception("No free places for tasks!");
		}
		return freeTasksCount;
	}
	
	public int getCurrentUnassignedTask() throws Exception { // what exception?
		int currentUnassignedTaskIndex = 0;
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i].getEmployee() == null) {
				currentUnassignedTaskIndex = i;
				return currentUnassignedTaskIndex;
			}
		}
		if (currentUnassignedTaskIndex + 1 == this.tasks.length) {
			throw new Exception("All tasks are assigned!");
		}
		return currentUnassignedTaskIndex;
	}
	
	private void setCurrentUnassignedTask(int currentUnassignedTaskIndex) {
		this.currentUnassignedTask = currentUnassignedTaskIndex;
	}
}
