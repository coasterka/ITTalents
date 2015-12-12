import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task09 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Pattern pattern = Pattern.compile("-?[0-9]+");
		// Matcher matcher = pattern.matcher("asd-12sdf45-56asdf100");
		Matcher matcher = pattern.matcher(input);
		int sum = 0;
		while (matcher.find()) {
			System.out.println(matcher.group());
			sum += Integer.parseInt(matcher.group());
		}
		System.out.println("Сума: " + sum);
	}
}
