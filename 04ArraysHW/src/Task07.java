import java.util.Scanner;

public class Task07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете дължина на масива:");
		int len = Integer.parseInt(sc.nextLine());
		int[] arr = new int[len];
		int[] newArr = new int[len];
		System.out.println("Въведете елементите на масива:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + 1 + ": ");
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		for (int i = 0; i < newArr.length; i++) {
			if(i == 0) {
				newArr[i] = arr[i+1] + arr[arr.length-1];
			}
			else if (i == newArr.length-1) {
				newArr[i] = arr[0] + arr[i-1];
			}
			else {
				newArr[i] = arr[i+1] + arr[i-1];
			}			
		}
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");
		}
	}
}
