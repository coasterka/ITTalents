
public class College {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student("Gancho", "Matematika", 20);
		Student s4 = new Student("Minka", "Ekologiq", 25);
		Student s5 = new Student("Velichko", "Matematika", 38);
		
		s1.setSubject("Matematika");
		
		//s2.receiveScholarship(5.5, 1000); // IllegalArgumentException: Student's age is not defined!
		s2.setAge(29);
		s2.receiveScholarship(5.5, 1000); // low grades
		System.out.println(s3.receiveScholarship(4.0, 200)); // 200
		
		s4.upYear(); // 1 -> 2
		System.out.println("Student 4 - Year in college: " + s4.getYearInCollege());
		
		s5.setYearInCollege(4);
		s5.upYear(); // zavurshi
		s5.upYear(); // veche e zavurshil
		
		StudentGroup sg1 = new StudentGroup();
		StudentGroup sg2 = new StudentGroup("Matematika");
		
		//sg2.addStudent(s4); // ekologiq =/= matematika
		//sg2.addStudent(s2); // IllegalArgumentException: Student's subject is not defined!
		//sg1.addStudent(s3); // IllegalArgumentException: Group's subject is not defined!
		sg2.addStudent(s1);
		sg2.addStudent(s3);
		sg2.addStudent(s5);
		
		s1.setGrade(6.00);
		s1.setName("Goshka");
		s5.setGrade(2.00);
		
		System.out.println(sg2.theBestStudent()); // s1 6.00 Goshka
		
		System.out.println(sg2.getFreePlaces()); // 3 students -> 2 free places out of 5
		
		sg2.emptyGroup();
		
		System.out.println(sg2.getFreePlaces()); // 5		
	}
}