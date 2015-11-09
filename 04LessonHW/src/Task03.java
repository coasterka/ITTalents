import java.util.Scanner;

public class Task03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете число:");
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			if (i <= 1) {
				arr[i] = n;
			}
			else {
				arr[i] = arr[i-1] + arr[i-2];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}