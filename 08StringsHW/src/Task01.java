import java.util.Scanner;

public class Task01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		String str1 = "";
		String str2 = "";
		while (str1.isEmpty() || str2.isEmpty() || (str1.length() + str2.length()) > 40) {
			System.out.println("Въведете последователно два низа, съдържащи до 40 главни и малки букви:");
			str1 = sc.next();
			str2 = sc.next();
		}
		System.out.print(str1.toUpperCase() + " ");
		System.out.print(str1.toLowerCase() + " ");
		System.out.print(str2.toUpperCase() + " ");
		System.out.println(str2.toLowerCase());
	}
}
