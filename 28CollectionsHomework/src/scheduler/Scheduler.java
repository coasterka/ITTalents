package scheduler;

import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {
	
	private Queue<ITask> tasks;
	
	public Scheduler() {
		this.tasks = new LinkedList<ITask>();
	}
	
	public void push(ITask task) throws TaskAlreadyExistsException {
		if (this.tasks.contains(task)) {
			throw new TaskAlreadyExistsException("This task has already been added to the scheduler!");
		}
		this.tasks.add(task);
	}
	
	public void main() throws EmptySchedulerException {
		if (this.tasks.isEmpty()) {
			throw new EmptySchedulerException("There are no tasks at the scheduler right now!");
		}
		for (ITask task : this.tasks) {
			System.out.println("Someone took a task! " + task.getClass().getName());
			task.doWork();
		}
	}
}
