import java.util.Scanner;

public class Task12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dayIn, monthIn, yearIn;
		int dayOut = 0, monthOut = 0, yearOut = 0;
		System.out.println("Въведете ден:");
		dayIn = Integer.parseInt(sc.nextLine());
		System.out.println("Въведете месец:");
		monthIn = Integer.parseInt(sc.nextLine());
		System.out.println("Въведете година:");
		yearIn = Integer.parseInt(sc.nextLine());
		boolean dataIsCorrect = (dayIn <= 31) && (monthIn <= 12) && yearIn > 0;
		boolean isSmallMonth = (monthIn == 2) || (monthIn == 4) || (monthIn == 6) ||
				(monthIn == 9) || (monthIn == 11);
		boolean isNewYear = (dayIn == 31) && (monthIn == 12);
		
		if (dataIsCorrect) {
			if ((dayIn == 28 && monthIn == 2 && !isLeap(yearIn)) ||
					(dayIn == 30 && isSmallMonth) ||
					(dayIn == 31 && !isSmallMonth)){
				dayOut = 1;
				monthOut = ++monthIn;
				yearOut = yearIn;
				if (isNewYear) {
					dayOut = 1;
					monthOut = 1;
					yearOut = ++yearIn;
				}
			}
			else if ((dayIn != 31 && !isSmallMonth) ||
					(dayIn != 30 && isSmallMonth)) {
				dayOut = ++dayIn;
				monthOut = monthIn;
				yearOut = yearIn;
			}
			System.out.printf("%d.%d.%d г.\n", dayOut, monthOut, yearOut);
		}
		else {
			System.out.println("Wrong data!");
		}
	}
	
	public static boolean isLeap(int year) {
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			return true;
		}
		else {
			return false;
		}
	}
}
