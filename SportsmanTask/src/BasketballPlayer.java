
public class BasketballPlayer extends Sportsman {
	private int seasonPoints;
	private static Sport sport = Sport.BASKETBALL;
	
	public BasketballPlayer() {}
	
	public BasketballPlayer(String name, int age, int seasonPoints) {
		super(name, age, sport);
		setSeasonPoints(seasonPoints);
	}

	public int getSeasonPoints() {
		return this.seasonPoints;
	}

	public void setSeasonPoints(int seasonPoints) {
		if (seasonPoints < 0) {
			throw new IllegalArgumentException("Season points can not be negative!");
		}
		this.seasonPoints = seasonPoints;
	}
}
