
public class StudentGroup {
	private String groupSubject;
	private Student[] students;
	private int freePlaces;
	
	public int getFreePlaces() {
		return this.freePlaces;
	}
	
	public StudentGroup() {
		this.students = new Student[5];
		this.freePlaces = 5;
	}
	
	public StudentGroup(String subject) {
		this();
		if (subject.isEmpty() || subject.equals(null)) {
			throw new IllegalArgumentException("Group subject can not be null!");
		}
		else {
			this.groupSubject = subject;
		}		
	}
	
	public void addStudent(Student s) {
		if (s == null) {
			throw new IllegalArgumentException("Student is not defined!");
		}
		if (this.groupSubject == null) {
			throw new IllegalArgumentException("Group's subject is not defined!");
		}
		if (s.getSubject() == null) {
			throw new IllegalArgumentException("Student's subject is not defined!");
		}
		if (this.freePlaces == 0) {
			System.out.println("There are no free places in this group!"); //exception?
			return;
		}
		if (!s.getSubject().equals(this.groupSubject)) {
			System.out.println("The student's and the group's subject don't match!"); //exception?
			return;
		}
		if (this.freePlaces > 0 && s.getSubject().equals(this.groupSubject)) {
			for (int i = 0; i < students.length; i++) {
				if (students[i] == null) {
					students[i] = s;
					this.freePlaces--;
					break;
				}
			}
		}
	}
	
	public void emptyGroup() {
		if (this.freePlaces == 5) {
			System.out.println("This group is already empty!");
			return;
		}
		this.students = new Student[5];
		this.freePlaces = 5;
	}
	
	public String theBestStudent() {
		String result = "";
		String bestStudentName = students[0].getName();
		double bestGrade = 0.0;
		if (this.freePlaces == 5) {
			result = "There are no students in this group!";
			return result;
		}
		for (int i = 0; i < students.length; i++) {
			Student currentStudent = students[i];
			if (currentStudent != null) {
				if (currentStudent.getName() == null) {
					result = "Student N" + (i + 1) + "'s name is not defined!";
					break;
				}
				if (currentStudent.getGrade() > bestGrade) {
					bestGrade = currentStudent.getGrade();
					bestStudentName = currentStudent.getName();
					result = bestStudentName;
				}
			}
			else {
				break;
			}
		}
		return result;
	}
	
	public void printStudentsInGroup() {
		if (this.freePlaces == 5) {
			System.out.println("There are no students in this group!");
			return;
		}
		for (int i = 0; i < students.length; i++) {
			Student currentStudent = students[i];
			String currentStudentAge =
					(currentStudent.getAge() == 0) ? "Not defined" : (currentStudent.getAge() + "");
			System.out.print("Name: " + currentStudent.getName() + ", Grade: " + 
					currentStudent.getGrade() + ", Age: " + currentStudentAge +
					", Money: " + currentStudent.getMoney());
		}
	}	
}