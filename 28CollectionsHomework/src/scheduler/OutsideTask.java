package scheduler;

public class OutsideTask implements ITask {

	@Override
	public void doWork() {
		System.out.println("Outside task is being worked on");		
	}

}
