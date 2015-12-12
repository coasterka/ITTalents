
public class Task03 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 4, 6, 3 },
				{ 5, 9, 7, 2 },
				{ 4, 8, 1, 9 },
				{ 2, 3, 4, 6 } };
		int sum = 0;
		double count = 0;
		double avg = 0.0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sum += arr[i][j];
				count++;
			}
		}
		avg = (double)(sum / count);
		System.out.println("Сума на елементите: " + sum);
		System.out.printf("Средно аритметично: %.2f", avg);
	}
}
