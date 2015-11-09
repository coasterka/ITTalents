import java.util.Scanner;

public class Task14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row1 = 0, column1 = 0;
		int row2 = 0, column2 = 0;
		while ((row1 < 1 || column1 < 1 || row2 < 1 || column2 < 1) ||
				(row1 > 8 || column1 > 8 || row2 > 8 || column2 > 8)){
			System.out.println("Въведете координати на 2 позиции от шахматната дъска" +
				" (от интервала [1.. 8].");
			row1 = sc.nextInt();
			column1 = sc.nextInt();
			row2 = sc.nextInt();
			column2 = sc.nextInt();
		}
		// same - row1 even, row2 odd, col1 even, col2 odd
		//		- row1 odd, row2 even, col1 odd, col2 even
		if ((row1 % 2 == 0 && row2 % 2 == 1 && column1 % 2 == 0 && column2 % 2 == 1) ||
				(row1 % 2 == 1 && row2 % 2 == 0 && column1 % 2 == 1 && column2 % 2 == 0)) {
			System.out.println("Позициите са с еднакъв цвят.");
		}
		else {
			System.out.println("Позициите са с различен цвят.");
		}
	}

}
