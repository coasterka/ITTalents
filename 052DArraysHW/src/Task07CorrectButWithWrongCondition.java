public class Task07CorrectButWithWrongCondition {
	
	public static void main(String[] args) {
		int[][] arr = { { 11, 12, 13, 14, 15, 16 },
				{ 21, 22, 23, 24, 25, 26 },
				{ 31, 32, 33, 34, 35, 36 },
				{ 41, 42, 43, 44, 45, 46 },
				{ 51, 52, 53, 54, 55, 56 },
				{ 61, 62, 63, 64, 65, 66 } };
		// sum of the elements whose indexes are as follows:
		// if even row -> even index
		// if odd row -> odd index
		int row = 0;
		int col = 0;
		int tempSum = 0;
		int rowSum = 0;
		int sumOfElements = 0;
		while (row < arr.length && col < arr[0].length) {
			tempSum = 0;
			if (row % 2 == 0) {
				if (col % 2 == 0) {
					tempSum += arr[row][col];
					rowSum += tempSum;
					System.out.print(arr[row][col] + ", ");
					if (col == arr[0].length - 1) {
						row++;
						col = 0;
					}
					else {
						col++;
					}
				}
				else {
					if (col == arr[0].length - 1) {
						System.out.println("Сума от елементите за реда: " + rowSum);
						row++;
						col = 0;
						rowSum = 0;
					}
					else {
						col++;
					}
				}
			}
			else if (row % 2 == 1) {
				if (col % 2 == 1) {
					tempSum += arr[row][col];
					rowSum += tempSum;
					System.out.print(arr[row][col] + ", ");
					if (col == arr[0].length - 1) {
						System.out.println("Сума от елементите за реда: " + rowSum);
						row++;
						col = 0;
						rowSum = 0;
					}
					else {
						col++;
					}
				}
				else {
					if (col == arr[0].length - 1) {						
						row++;
						col = 0;
					}
					else {
						col++;
					}
				}
			}
			sumOfElements += tempSum;
		}
		System.out.println("Сума на елементите: " + sumOfElements);
	}
}