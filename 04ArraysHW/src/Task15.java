import java.util.Scanner;

public class Task15 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Въведете дължина на масива > 3:");
//		int len = Integer.parseInt(sc.nextLine());
//		double[] arr = new double[len];
//		System.out.println("Въведете елементите на масива:");
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(i+1 + ": ");
//			arr[i] = Double.parseDouble(sc.nextLine());
//		}
		double[] arr = { 7.13, 0.2, 4.9, 5.1, 6.34, 1.12 };
		double maxSum = Math.abs(arr[0]) + Math.abs(arr[1]) + Math.abs(arr[2]);
		double tempSum = 0;
		int idx1 = 0, idx2 = 0, idx3 = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				for (int k = j+1; k < arr.length; k++) {
					tempSum = Math.abs(arr[i]) + Math.abs(arr[j]) + Math.abs(arr[k]);
					if (tempSum > maxSum && arr[i] != arr[j] &&
							arr[i] != arr[k] && arr[j] != arr[k]) {
						maxSum = tempSum;
						idx1 = i;
						idx2 = j;
						idx3 = k;
					}
				}
			}
		}
		System.out.println(arr[idx1] + "; " + arr[idx2] + "; " + arr[idx3]);
	}
}