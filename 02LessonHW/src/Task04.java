import java.util.Scanner;

public class Task04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int firstNum = 0, secondNum = 0;
		while (firstNum == secondNum){
			System.out.println("Въведете две различни целочислени числа:");
			firstNum = Integer.parseInt(sc.nextLine());
			secondNum = Integer.parseInt(sc.nextLine());
		}
		if (firstNum < secondNum) {
			System.out.printf("%d %d\n", firstNum, secondNum);
		}
		else {
			System.out.printf("%d %d\n", secondNum, firstNum);
		}
	}
}
