import java.util.Scanner;

public class Task15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете N:");
		int n = Integer.parseInt(sc.nextLine());
		int temp = 1;
		int sum = 0;
		do {
			sum += temp;
			temp++;
		}
		while (temp <= n);
		System.out.println(sum);
	}
}
