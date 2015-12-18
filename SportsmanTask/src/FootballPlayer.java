
public class FootballPlayer extends Sportsman {
	private int countOfGoals;
	private static Sport sport = Sport.FOOTBALL;
	
	public FootballPlayer() {}
	
	public FootballPlayer(String name, int age, int countOfGoals) {
		super(name, age, sport);
		setCountOfGoals(countOfGoals);
	}
	
	public int getCountOfGoals() {
		return this.countOfGoals;
	}
	
	public void setCountOfGoals(int countOfGoals) {
		if (countOfGoals < 0) {
			throw new IllegalArgumentException("Count of goals can not be negative!");
		}
		this.countOfGoals = countOfGoals;
	}
}
