import java.util.Scanner;

public class Task07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете целочислено число за час:");
		int hour = Integer.parseInt(sc.nextLine());
		System.out.println("Въведете число с плаваща запетая за сума пари:");
		float money = Float.parseFloat(sc.nextLine());
		System.out.println("Въведете true или false (здрав ли съм):");
		boolean amHealthy = Boolean.parseBoolean(sc.nextLine());
		if (amHealthy) {
			if (money >= 10.0F) {
				System.out.println("Ще отида на кино с приятели.");
			}
			else {
				System.out.println("Ще отида на кафе.");
			}
		}
		else {
			System.out.println("Няма да излизам.");
			if (money > 0) {
				System.out.println("Ще си купя лекарства.");
			}
			else {
				System.out.println("Ще стоя вкъщи и ще пия чай.");
			}
		}
	}
}