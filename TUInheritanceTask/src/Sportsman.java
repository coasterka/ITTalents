
public class Sportsman {
	private String name;
	private int age;
	private Sport sport;
	
	public Sportsman() {};
	
	public Sportsman(String name, int age, Sport sport) {
		setName(name);
		setAge(age);
		setSport(sport);
	}
	
	public static void findBestSportsman(Sportsman[] sportsmen) {
		Sportsman bestPlayer = sportsmen[0];
		int maxPoints = 0;
			
		for (int i = 0; i < sportsmen.length; i++) {
			int currentPlayerPoints = 0;
			if (bestPlayer instanceof BasketballPlayer) {
				currentPlayerPoints = ((BasketballPlayer)sportsmen[i]).getSeasonPoints();
			}
			else {
				currentPlayerPoints = ((FootballPlayer)sportsmen[i]).getCountOfGoals();
			}
			if (currentPlayerPoints > maxPoints) {
				maxPoints = currentPlayerPoints;
				bestPlayer = sportsmen[i];
			}
		}
			printSportsmanInfo(bestPlayer);
	}
	
	private static void printSportsmanPoints(Sportsman sportsman) {
		String sportsmanPoints = "";
		if (sportsman instanceof FootballPlayer) {
			sportsmanPoints += "Count of goals: " + ((FootballPlayer) sportsman).getCountOfGoals();
		}
		else if (sportsman instanceof BasketballPlayer) {
			sportsmanPoints += "Season points: " + ((BasketballPlayer) sportsman).getSeasonPoints();
		}
		System.out.println(sportsmanPoints);
	}
	
	public static void printSportsmanInfo(Sportsman sportsman) {
		String sportsmanInfo = "";
		sportsmanInfo += "Name: " + sportsman.getName();
		sportsmanInfo += "\nAge: " + sportsman.getAge();
		sportsmanInfo += "\nSport: " + sportsman.getSport();
		System.out.println(sportsmanInfo);
		printSportsmanPoints(sportsman);
	}
	
	public static void showSportsmanAboveAge(Sportsman[] sportsmen, int minAge) {
		int countOfOldPlayers = 0;
		for (int i = 0; i < sportsmen.length; i++) {
			Sportsman currentPlayer = sportsmen[i];
			if (currentPlayer.getAge() >= minAge) {
				countOfOldPlayers++;
				printSportsmanInfo(currentPlayer);
			}
		}
		if (countOfOldPlayers == 0) {
			System.out.println("No players above the age of " + minAge);
			return;
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name can not be null or empty!");
		}
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		if (age <= 0 || age > 120) {
			throw new IllegalArgumentException("Invalid age! Must be in range [1.. 120]!");
		}
		this.age = age;
	}

	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		if (sport == null) {
			throw new IllegalArgumentException("Sport type can not be null!");
		}
		this.sport = sport;
	}	
}
