import java.util.Scanner;

public class Task07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете n:");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 3; i <= n*3; i+=3) {
			System.out.print(i + ",");
		}
	}
}
