package scheduler;

public class BankTask implements ITask {

	@Override
	public void doWork() {
		System.out.println("Bank task is being worked on");	
	}

}
