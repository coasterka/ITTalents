import java.util.Scanner;

public class Task06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете дължина на първия масив:");
		int len1 = Integer.parseInt(sc.nextLine());
		System.out.println("Въведете дължина на втория масив:");
		int len2 = Integer.parseInt(sc.nextLine());
		if (len1 != len2) {
			System.out.println("Масивите са с различна дължина.");
		}
		else {
			int[] arr1 = new int[len1];
			int[] arr2 = new int[len2];
			boolean same = false;
			System.out.println("Въведете елементите на първия масив:");
			for (int i = 0; i < arr1.length; i++) {
				System.out.print(i + 1 + ": ");
				arr1[i] = Integer.parseInt(sc.nextLine());				
			}
			System.out.println("Въведете елементите на втория масив:");
			for (int i = 0; i < arr2.length; i++) {
				System.out.print(i + 1 + ": ");
				arr2[i] = Integer.parseInt(sc.nextLine());
			}
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] != arr2[i]) {
					System.out.println("Масивите не са еднакви.");
					break;
				}
				else {
					same = true;
				}
			}
			if (same == true) {
				System.out.println("Масивите са еднакви.");
			}
		}
	}
}
