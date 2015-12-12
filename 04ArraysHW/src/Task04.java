import java.util.Scanner;

public class Task04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете дължина на масива:");
		int length = Integer.parseInt(sc.nextLine());
		int[] arr = new int[length];
		if (arr.length == 1) {
			System.out.println("Масивът е огледален.");
		}
		else {
			System.out.println("Въведете елементите на масива:");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(i + 1 + ": ");
				arr[i] = Integer.parseInt(sc.nextLine());
			}
			int i = 0;
			int j = arr.length - 1;
			while (i <= j) {			
				if (arr[i] != arr[j]) {
					System.out.println("Масивът не е огледален.");
					break;
				}
				else {
					i++;
					j--;
					if (i == j || i == j - 1) {
						System.out.println("Масивът е огледален.");
					}
				}
			}
		}
	}
}