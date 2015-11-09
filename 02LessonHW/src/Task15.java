import java.util.Scanner;

public class Task15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hour = -1;
		while (hour < 0 || hour > 24){
			System.out.println("Въведете естествено число от интервала [0.. 24]");
			hour = Integer.parseInt(sc.nextLine());
		}
		if ((hour >= 18 && hour < 24)  || (hour >= 0 && hour < 4)) {
			System.out.println("Добър вечер.");
		}
		else if (hour >= 4 && hour < 9) {
			System.out.println("Добро утро.");
		}
		else {
			System.out.println("Добър ден.");
		}
	}
}