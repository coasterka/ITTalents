public class Task06 {
	
	public static void main(String[] args) {
		int[][] arr = { { 11, 12, 13, 14, 15, 16 },
				{ 21, 22, 23, 24, 25, 26 },
				{ 31, 32, 33, 34, 35, 36 },
				{ 41, 42, 43, 44, 45, 46 },
				{ 51, 52, 53, 54, 55, 56 },
				{ 61, 62, 63, 64, 65, 66 } };
		int tempSum = 0;
		int wholeSum = 0;
		for (int row = 0; row < arr.length; row++) {
			tempSum = 0;
			for (int col = 0; col < arr[0].length; col++) {
				if ((row+1) % 2 == 0) {
					System.out.print(arr[row][col] + ", ");
					tempSum += arr[row][col];
				}
			}
			if ((row+1) % 2 == 0){
				System.out.println(" сума: " + tempSum);
			}
			wholeSum += tempSum;
		}
		System.out.println("Сума на елементите: " + wholeSum);
	}
}