import java.util.Scanner;

public class Task10 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[7];
		double avg = 0.0;
		int sum = 0;
		int index = 0;		
		System.out.println("Въведете 7 цели числа:");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
			sum += arr[i];
		}
		avg = (double) sum / arr.length;
		double minDiff = Math.abs(arr[0] - avg);
		double tempDiff = 0;
		for (int i = 1; i < arr.length; i++) {
			tempDiff = (double) Math.abs(arr[i] - avg);
			if (tempDiff < minDiff) {
				index = i;
				minDiff = tempDiff;
			}
		}
		System.out.println(arr[index]);
	}
}
