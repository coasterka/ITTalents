import java.util.Scanner;

public class Task09 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете дължина на масива:");
		int len = Integer.parseInt(sc.nextLine());
		int[] arr = new int[len];
		int[] newArr = new int[len];
		System.out.println("Въведете елементите на масива:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i+1 + ": ");
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		int i = 0;
		int j = newArr.length - 1;
		while (i < newArr.length) {
			newArr[i] = arr[j];
			i++;
			j--;
		}
		for (int k = 0; k < newArr.length; k++) {
			System.out.print(newArr[k] + " ");
		}
	}
}