import java.util.Scanner;

public class Task11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 100;
		while (String.valueOf(num).contains("0") ||
				String.valueOf(num).length() != 3){
			System.out.println("Въведете трицифрено число, което не съдържа цифра 0:");
			num = Integer.parseInt(sc.nextLine());
		}
		int a = (num % 1000) / 100;
		int b = (num % 100) / 10;
		int c = num % 10;
		if ((num % a == 0) && (num % b == 0) && (num % c == 0)) {
			System.out.println("Въведеното число се дели на всяка своя цифра.");
		}
		else {
			System.out.println("Въведеното число не се дели на всяка своя цифра.");
		}
	}
}