import java.util.Scanner;

public class Task07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		String longestWord = "";
		int maxLength = Integer.MIN_VALUE;
		while (str.isEmpty()) {
			System.out.println("Въведете набор от думи, разделени с интервал:");
			str = sc.nextLine();
		}
		String[] words = str.split(" ");
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].trim();
		}
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > maxLength) {
				maxLength = words[i].length();
				longestWord = words[i];
			}
		}
		System.out.println(words.length + " думи, най-дългата е с " + maxLength + " символа и е: " +
				longestWord);
	}
}
