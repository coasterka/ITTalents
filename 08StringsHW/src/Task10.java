import java.util.Scanner;

public class Task10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		String newStr = "";
		while (str.isEmpty()) {
			System.out.println("Въведете дума:");
			str = sc.nextLine();
		}
		for (int i = 0; i < str.length(); i++) {
			newStr += Character.toString((char) (str.charAt(i) + 5));
		}
		System.out.println(newStr);
	}
}