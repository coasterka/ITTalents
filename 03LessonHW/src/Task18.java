import java.util.Scanner;

public class Task18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете първото число [1.. 9]:");
		short firstNum = Short.parseShort(sc.nextLine());
		System.out.println("Въведете второто число [1.. 9]:");
		short secondNum = Short.parseShort(sc.nextLine());
		for (int i = 1; i <= firstNum; i++) {
			for (int j = 1; j <= secondNum; j++) {
				System.out.print(i + " * ");
				System.out.print(j + " = ");
				System.out.println(i * j);
			}
			
		}
	}
}
