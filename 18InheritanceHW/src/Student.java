
public class Student extends Person {
	private double score;
	
	public Student(String name, int age, boolean isMale, double score) {
		super(name, age, isMale);
		setScore(score);
	}
	
	public void showStudentInfo() {
		super.showPersonInfo();
		System.out.println("Score: " + this.getScore());
	}
	
	public double getScore() {
		return this.score;
	}
	
	public void setScore(double score) {
		if (score < 2 || score > 6) {
			throw new IllegalArgumentException("Invalid student score! Must be in range [2.. 6]!");
		}
		this.score = score;
	}	
}
