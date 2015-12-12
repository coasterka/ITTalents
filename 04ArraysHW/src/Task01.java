import java.util.Scanner;

public class Task01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете дължина на масива:");
		int length = Integer.parseInt(sc.nextLine());
		int[] arr = new int[length];
		System.out.println("Въведете елементите на масива:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + 1 + ": ");
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		int smallest = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < smallest && arr[i] % 3 == 0) {
				smallest = arr[i];
			}
		}
		System.out.println(smallest);
	}
}