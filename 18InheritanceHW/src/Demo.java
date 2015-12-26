
public class Demo {
	public static void main(String[] args) {
		Person[] people = new Person[10];
		
		Person achkata = new Person("Achkata", 28, true);
		Person marincho = new Person("Marincho", 65, true);
		Student dorotei = new Student("Dorotei", 19, true, 4.20);
		Student mara = new Student("Mara", 25, false, 3.90);
		Employee georgica = new Employee("Georgica", 37, false, 20);
		Employee nikolo = new Employee("Nikolo", 81, true, 24);
		
		people[0] = achkata;
		people[1] = marincho;
		people[2] = dorotei;
		people[3] = mara;
		people[4] = georgica;
		people[5] = nikolo;
		
		for (int i = 0; i < people.length; i++) {
			Person currentPerson = people[i];
			if (currentPerson != null) {
				if (currentPerson instanceof Student) {
					((Student) currentPerson).showStudentInfo();
				}
				else if (currentPerson instanceof Employee) {
					((Employee) currentPerson).showEmployeeInfo();
				}
				else {
					currentPerson.showPersonInfo();
				}
			}
		}
		
		for (int i = 0; i < people.length; i++) {
			Person currentPerson = people[i];
			if ((currentPerson instanceof Employee) && (currentPerson != null)) {
				double result = ((Employee) currentPerson).calculateOvertime(2);
				System.out.printf("%s Overtime Pay: %.2f\n", currentPerson.getName(), result);
			}
		}
	}
}
