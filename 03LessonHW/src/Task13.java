import java.util.Scanner;

public class Task13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете цяло естествено число от интервала [2.. 27]");
		int sum = Integer.parseInt(sc.nextLine());
		// digits
		int a, b, c;
		for (int i = 100; i <= 999; i++) {
			a = (i % 1000) / 100;
			b = (i % 100) / 10;
			c = i % 10;
			if (a + b + c == sum) {
				System.out.println(i);
			}
		}
	}
}
