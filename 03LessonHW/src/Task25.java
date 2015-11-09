import java.util.Scanner;

public class Task25 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		short n = 26;
		while (n > 25) {
			System.out.println("Въведете число N от интервала [1.. 25]:");
			n = Short.parseShort(sc.nextLine());			
		}
		if (n <= 25) {
			long result = 1;
			int i = 1;
			do {
				result *= i;
				i++;
			}
			while (i <= n);
			System.out.println(result);
		}
	}
}
