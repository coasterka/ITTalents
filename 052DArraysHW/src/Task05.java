public class Task05 {
	
	public static void main(String[] args) {
		int[][] arr = { {1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };		
		int tempSumRows = 0;
		int tempSumCols = 0;
		int maxSumRows = 0;
		int maxSumCols = 0;
		for (int i = 0; i < arr.length; i++) {
			tempSumRows = 0;
			tempSumCols = 0;
			for (int j = 0; j < arr.length; j++) {
				tempSumRows += arr[i][j];
				tempSumCols += arr[j][i];
			}
			if (tempSumRows > maxSumRows) {
				maxSumRows = tempSumRows;
			}
			if (tempSumCols > maxSumCols) {
				maxSumCols = tempSumCols;
			}
		}
		char sign = (maxSumRows > maxSumCols) ? '>' : '<';
		System.out.println("Най-голямата сума по редове: " + maxSumRows);
		System.out.println("Най-голямата сума по колони: " + maxSumCols);
		System.out.println("Максималната сума по редове е " + sign +
				" от максималната сума по колони.");
	}
}