import java.util.Scanner;

public class Task11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[7];
		int count = 0;
		System.out.println("Въведете 7 цели числа:");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 5 == 0 && arr[i] > 5) {
				count++;
				System.out.print(arr[i] + ", ");
			}
		}
		System.out.println(count + " числа.");
	}
}
