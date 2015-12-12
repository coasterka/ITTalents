import java.util.Scanner;

public class Task08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		while (str.isEmpty()) {
			System.out.println("Въведете ред от символи:");
			str = sc.nextLine();
		}
		int i = 0;
		int j = str.length() - 1;
		while (i <= j) {
			if (str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
				if (i == j || i == j-1) {
					System.out.println("Въведеният стринг е палиндром.");
					break;
				}				
			}
			else {
				System.out.println("Въведеният стринг не е палиндром.");
				break;
			}
		}
	}
}
