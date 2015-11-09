import java.util.Scanner;

public class Task16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете число N от интервала [10.. 5555]:");
		int n = Integer.parseInt(sc.nextLine());
		System.out.println("Въведете число M от интервала [10.. 5555]:");
		int m = Integer.parseInt(sc.nextLine());
		int start, end;
		if (n > m) {
			start = n;
			end = m;
		}
		else {
			start = m;
			end = n;
		}
		for (int i = start; i >= end; i--) {
			if (i % 50 == 0) {
				System.out.println(i);
			}
		}
	}
}
