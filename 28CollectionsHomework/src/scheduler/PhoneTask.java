package scheduler;

public class PhoneTask implements ITask {

	@Override
	public void doWork() {
		System.out.println("Phone task is being worked on");		
	}

}
