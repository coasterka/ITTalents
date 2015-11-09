import java.util.Scanner;

public class Task10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете N:");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				System.out.println("Числото не е просто.");
				break;
			}
			if (n % i != 0) {
				System.out.println("Числото е просто.");
				break;
			}
		}
	}
}
