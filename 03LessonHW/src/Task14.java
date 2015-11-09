import java.util.Scanner;

public class Task14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете цяло естествено число от интервала [10.. 200]:");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = n; i >= 7; i--) {
			if (i % 7 == 0) {
				System.out.println(i);
			}
		}
	}
}
