public class Task07 {
	public static void main(String[] args) {
		int[][] arr = { { 11, 12, 13, 14, 15, 16 },
				{ 21, 22, 23, 24, 25, 26 },
				{ 31, 32, 33, 34, 35, 36 },
				{ 41, 42, 43, 44, 45, 46 },
				{ 51, 52, 53, 54, 55, 56 },
				{ 61, 62, 63, 64, 65, 66 } };
		// sum of the elements whose row and column indexes are both even
		int row = 0;
		int col = 0;
		int rowSum = 0;
		int sumOfElements = 0;
		while (row < arr.length && col < arr[0].length) {
			if ((row + col) % 2 == 0) {
				sumOfElements += arr[row][col];
				System.out.print(arr[row][col] + ", ");
				rowSum += arr[row][col];
				if (col == arr.length - 1) {
					row++;
					col = 0;
					System.out.println("Сума от елементите за реда: " + rowSum);
					rowSum = 0;
				}
				else {
					col++;
				}
			}
			else {
				if (col == arr.length - 1) {
					row++;
					col = 0;
					System.out.println("Сума от елементите за реда: " + rowSum);
					rowSum = 0;
				}
				else {
					col++;
				}
			}
		}
		System.out.println("Сума на елементите: " + sumOfElements);
	}
}