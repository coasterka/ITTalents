
public class Company {
	public static void main(String[] args) {
		Employee em1 = new Employee("Strashil");
		Employee em2 = new Employee("Petkan");
		Task t1 = new Task("Upload files to server", 7);
		Task t2 = new Task("Test the latest version", 10);
		
		em1.setHoursLeft(10);		
		em1.setCurrentTask(t1);		
		em1.work();		
		em1.setCurrentTask(t2);		
		em1.work();
		
		em2.setHoursLeft(6);		
		em2.setCurrentTask(t2);		
		em2.work();
	}
}