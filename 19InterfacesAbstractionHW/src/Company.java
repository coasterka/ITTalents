
public class Company {
	public static void main(String[] args) throws Exception {
		AllWork tasks = new AllWork();
		Task task01 = new Task("Clean the office", 12);
		Task task02 = new Task("Restart the server", 10);
		Task task03 = new Task("Argue with the boss", 3);
		Task task04 = new Task("Make coffee for the colleagues", 4);
		Employee em01 = new Employee("Grisho");
		Employee em02 = new Employee("Latinka");
		tasks.addTask(task01);
		tasks.addTask(task02);
		tasks.addTask(task03);
		tasks.addTask(task04);
		em01.setAllWork(tasks);
		em02.setAllWork(tasks);
		
		em01.setCurrentTask(task01);
		//em02.setCurrentTask(task02);
		while(true) {
			em01.work();
			//em02.work();
		}
	}
}
