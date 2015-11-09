import java.util.Scanner;

public class Task22 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете естествено число от интервала [1.. 999]:");
		int n = Integer.parseInt(sc.nextLine());
		int i = 1;
		while (i <= 10) {
			if ((n % 2 == 0) || (n % 3 == 0) || (n % 5 == 0)) {
				System.out.print(i + ":" + n + ", ");
				i++;
				n++;
			}
			else {
				n++;
			}			
		}
	}
}
