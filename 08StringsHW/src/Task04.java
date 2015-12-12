import java.util.Scanner;

public class Task04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] names = {};
		int charSum1 = 0;
		int charSum2 = 0;
		int maxSum = 0;
		while (names.length == 0) {
			System.out.println("Въведете три имена на двамата човека, разделени със запетая:");
			names = sc.nextLine().split(",");
		}
		for (int i = 0; i < names.length; i++) {
			names[i] = names[i].trim();
		}
		for (int i = 0; i < names[0].length(); i++) {
			charSum1 += (int) names[0].charAt(i);
		}
		for (int i = 0; i < names[1].length(); i++) {
			charSum2 += (int) names[1].charAt(i);
		}
		// System.out.println(charSum1 + " " + charSum2);
		if (charSum1 > charSum2) {
			System.out.println(names[0]);
		}
		else {
			System.out.println(names[1]);
		}
	}
}
