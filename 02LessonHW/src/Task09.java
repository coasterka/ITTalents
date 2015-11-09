import java.util.Scanner;

public class Task09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int firstNum = 0, secondNum = 0;
		int product = 0;
		while ((firstNum < 10 || firstNum > 99) ||
				(secondNum < 10 || secondNum > 99)){
			System.out.println("Въведете две естествени двуцифрени числа:");
			firstNum = Integer.parseInt(sc.nextLine());
			secondNum = Integer.parseInt(sc.nextLine());
		}
		product = firstNum * secondNum;
		byte lastDigit = (byte)(product % 10);
		if (lastDigit % 2 == 0)
			System.out.printf("%d, %d четна.\n", product, lastDigit);
		else
			System.out.printf("%d, %d нечетна.\n", product, lastDigit);
	}

}
