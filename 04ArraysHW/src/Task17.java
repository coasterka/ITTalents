import java.util.Scanner;

public class Task17 {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Въведете дължина на редицата:");
		//int len = Integer.parseInt(sc.nextLine());
		//int[] arr = new int[len];
		//System.out.println("Въведете елементите на редицата (естествени числа):");
		//for (int i = 0; i < arr.length; i++) {
		//	System.out.print(i+1 + ": ");
		//	arr[i] = Integer.parseInt(sc.nextLine());
		//}
		boolean isZigzag = true;
		int count = 0;
		int[] arr = {1, 3, 2, 4, 3, 7, 6};
		for (int i = 0; i < arr.length - 1; i++) {
			if (i % 2 == 0) {
				if (arr[i] < arr[i+1]) {
					count++;
				}
				else {
					isZigzag = false;
					break;
				}
			}
			else if (i % 2 == 1) {
				if (arr[i] > arr[i+1]) {
					count++;
				}
				else {
					isZigzag = false;
					break;
				}
			}
		}
		if (count == arr.length - 1) {
			System.out.println("Изпълнява изискванията за зигзагообразна нагоре редица.");
		}
		if (!isZigzag) {
			System.out.println("Не изпълнява изискванията за зигзагообразна нагоре редица.");
		}
	}
}
