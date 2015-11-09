import java.util.Scanner;

public class Task05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете първото число:");
		int firstNum = Integer.parseInt(sc.nextLine());
		System.out.println("Въведето второто число:");
		int secondNum = Integer.parseInt(sc.nextLine());
		int start, end;
		if (firstNum > secondNum) {
			start = secondNum;
			end = firstNum;
		}
		else {
			start = firstNum;
			end = secondNum;
		}
		for (int i = start; i <= end; i++) {
			System.out.print(i + " ");
		}
	}
}
