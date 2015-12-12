import java.util.Scanner;

public class Task06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		while (str.isEmpty()) {
			System.out.println("Въведете изречение:");
			str = sc.nextLine();
		}
		String[] words = str.split(" ");
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].replace(words[i].substring(0, 1),
					words[i].substring(0, 1).toUpperCase());
		}
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i] + " ");
		}
	}
}
