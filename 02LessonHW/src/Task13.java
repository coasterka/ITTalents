import java.util.Scanner;

public class Task13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temperature = 0;
		while (temperature < -100 || temperature > 100) {
			System.out.println("Въведете температура t в градус Целзий:");
			temperature = Integer.parseInt(sc.nextLine());
		}
		if (temperature < -20) {
			System.out.println("ледено студено");
		}
		else if (temperature >= -20 && temperature < 0) {
			System.out.println("студено");
		}
		else if (temperature >= 0 && temperature < 15) {
			System.out.println("хладно");
		}
		else if (temperature >= 15 && temperature < 25) {
			System.out.println("топло");
		}
		else {
			System.out.println("горещо");
		}
	}
}
