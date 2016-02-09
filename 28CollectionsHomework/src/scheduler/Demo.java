package scheduler;

import java.util.ArrayList;

public class Demo {
	private static final int NUMBER_OF_TASKS = 5;

	public static void main(String[] args) throws TaskAlreadyExistsException, EmptySchedulerException {
		Scheduler scheduler = new Scheduler();
		ArrayList<ITask> tasks = new ArrayList<ITask>();
		for (int task = 1; task <= NUMBER_OF_TASKS; task++) {
			double randomTask = Math.random();
			ITask currentTask;
			if (randomTask < 0.25) {
				currentTask = new BankTask();
			}
			else if (randomTask >= 0.25 && randomTask < 0.5) {
				currentTask = new OfficeTask();
			}
			else if (randomTask >= 0.5 && randomTask < 0.75) {
				currentTask = new PhoneTask();
			}
			else {
				currentTask = new OutsideTask();
			}
			scheduler.push(currentTask);
		}
		scheduler.main();
	}
}
