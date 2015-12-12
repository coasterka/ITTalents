import java.util.Scanner;

public class Task02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = "";
		String str2 = "";
		int maxLength = 0;
		while (str1.isEmpty() || str2.isEmpty() || (str1.length() + str2.length()) < 10 ||
				(str1.length() + str2.length()) > 20 || str1.length() < 5 || str2.length() < 5) {
			System.out.println("Въведете последователно две думи с дължина [10.. 20]:");
			str1 = sc.next();
			str2 = sc.next();
		}
		String newStr1 = str1.replace(str1.substring(0, 6), str2.substring(0, 6));
		String newStr2 = str2.replace(str2.substring(0, 6), str1.substring(0, 6));
		maxLength = (newStr1.length() > newStr2.length()) ? newStr1.length() : newStr2.length();
		System.out.println(maxLength + " " + newStr1 + " " + newStr2);
	}
}
