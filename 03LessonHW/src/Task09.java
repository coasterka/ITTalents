import java.util.Scanner;

public class Task09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pow = 0;
		int sum = 0;
		System.out.println("Въведете А:");
		int a = Integer.parseInt(sc.nextLine());
		System.out.println("Въведете B:");
		int b = Integer.parseInt(sc.nextLine());
		for (int i = a; i <= b; i++) {
			pow = (int) Math.pow(i, 2);
			if (sum <= 200) {				
				if (pow % 3 == 0) {
					System.out.println("skip 3");
				}
				else {
					System.out.println(pow);
					sum += pow;
				}
			}
			else {
				break;
			}
		}
	}
}
