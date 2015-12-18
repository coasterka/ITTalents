
public class Demo {
	public static void main(String[] args) {
		FootballPlayer football1 = new FootballPlayer("Pesho", 2, 15);
		FootballPlayer football2 = new FootballPlayer("Gosho", 25, 5);
		FootballPlayer football3 = new FootballPlayer("Misho", 19, 7);
		Sportsman[] footballPlayers = new FootballPlayer[] { football1, football2, football3 };
		
		//Sportsman.findBestSportsman(footballPlayers);
		
		BasketballPlayer basket1 = new BasketballPlayer("Gencho", 16, 6);
		BasketballPlayer basket2 = new BasketballPlayer("Tishko", 20, 1);
		BasketballPlayer basket3 = new BasketballPlayer("Mincho", 19, 3);
		Sportsman[] basketballPlayers = new BasketballPlayer[] { basket1, basket2, basket3 };
		
		//Sportsman.findBestSportsman(basketballPlayers);
		
		Sportsman.showSportsmanAboveAge(basketballPlayers, 19);
		
	}
}

