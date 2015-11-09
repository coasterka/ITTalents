import java.util.Scanner;

public class Task16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while (String.valueOf(num).length() != 3){
			System.out.println("Въведете естествено трицифрено число:");
			num = Integer.parseInt(sc.nextLine());
		}
		int a = (num % 1000) / 100;
		int b = (num % 100) / 10;
		int c = num % 10;
		if (a == b && a == c && b == c)
			System.out.println("Цифрите са равни.");
		else if (a > b && b > c)
			System.out.println("Цифрите са в низходящ ред.");
		else if (a < b && b < c)
			System.out.println("Цифрите са във възходящ ред.");
		else
			System.out.println("Цифрите са ненаредени.");
	}

}
