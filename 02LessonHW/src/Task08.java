import java.util.Scanner;

public class Task08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = 0;
		String numCheckStr = Integer.toString(number);
		while ((numCheckStr.length() == 0) || (numCheckStr.length() != 4)) {
			System.out.println("Въведете 4-цифрено естествено число от интервала [1000.. 9999].");
			number = Integer.parseInt(sc.nextLine());
			numCheckStr = Integer.toString(number);
		}
		
		int a = (number % 10000) / 1000;
		int b = (number % 1000) / 100;
		int c = (number % 100) / 10;
		int d = number % 10;
		
		int firstNum = Integer.parseInt(a + "" + d);
		int secondNum = Integer.parseInt(b + "" + c);
		
		if (firstNum < secondNum) {
			System.out.printf("по-малко (%d<%d)\n", firstNum, secondNum);
		}
		else if (firstNum == secondNum) {
			System.out.printf("равни (%d=%d)\n", firstNum, secondNum);
		}
		else {
			System.out.printf("по-голямо (%d>%d)\n", firstNum, secondNum);
		}
	}
}