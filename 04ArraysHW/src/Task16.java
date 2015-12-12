public class Task16 {
	public static void main(String[] args) {
		double[] arr = { -1.12, -2.43, 3.1, 4.2, 0, 6.4, -7.5, 8.6, 9.1, -4 };
		double[] newArr = new double[arr.length];
		double sum = 0;
		int countOfNumbersNotZero = 0;
		double avg = 0;
		// print the old array and fill the new one
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
			if (arr[i] != 0) {
				sum += arr[i];
				countOfNumbersNotZero++;
			}
			if (arr[i] < -0.231) {
				newArr[i] = Math.pow((i+1), 2) + 41.25;
			}
			else {
				newArr[i] = arr[i] * (i+1);
			}
		}
		System.out.println();
		// print the new array
		for (int i = 0; i < newArr.length; i++) {
			System.out.printf("%.2f, ", newArr[i]);
		}
		avg = (double) sum / countOfNumbersNotZero;
		System.out.printf("\nAverage: %.2f", avg);
	}
}
