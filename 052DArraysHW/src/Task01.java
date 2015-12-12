
public class Task01 {
	public static void main(String[] args) {
		int[][] arr = { { 48, 72, 13, 14, 15 },
			{ 21, 22, 53, 24, 75 },
			{ 31, 57, 33, 34, 35 },
			{ 41, 95, 43, 44, 45 },
			{ 59, 52, 53, 54, 55 },
			{ 61, 69, 63, 64, 65 } };
		int smallest = arr[0][0];
		int largest = arr[0][0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] < smallest) {
					smallest = arr[i][j];
				}
				if (arr[i][j] > largest) {
					largest = arr[i][j];
				}
			}
		}
		System.out.println("Най-малко: " + smallest);
		System.out.println("Най-голямо: " + largest);
	}
}
