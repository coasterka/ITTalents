import java.util.Scanner;

public class Task02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = { { 1, 4, 6, 3 },
				{ 5, 9, 7, 2 },
				{ 4, 8, 1, 9 },
				{ 2, 3, 4, 5 } };
		int i = 0;
		// print the first diagonal
		while (i < arr[0].length) {
			System.out.print(arr[i][i] + " ");
			i++;
		}
		System.out.println();
		// print the second diagonal
		i = 0;
		int j = arr[0].length - 1;
		while (i < arr[0].length) {
			System.out.print(arr[i][j] + " ");
			i++;
			j--;
		}
	}
}