import java.util.Scanner;

public class Task03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = "";
		String str2 = "";
		int minLength = 0;
		while (str1.isEmpty() || str2.isEmpty()) {
			System.out.println("Въведете два последователни низа:");
			str1 = sc.next();
			str2 = sc.next();
		}
		minLength = (str1.length() < str2.length()) ? str1.length() : str2.length();
		if (str1.length() != str2.length()) {
			System.out.println("Двата низа са с различна дължина.");
		}
		else {
			System.out.println("Двата низа са с равна дължина.");
		}
		System.out.println("Разлика по позиции:");
		for (int i = 0; i < minLength; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				System.out.println(i+1 + " " + str1.charAt(i) + "-" + str2.charAt(i));
			}
		}
	}
}
