import java.util.Scanner;

public class Task06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = 0, a2 = 0, a3 = 0;
		int temp1, temp2;
		while (a1 == a2 || a1 == a3 || a2 == a3){
			System.out.println("Въведете три различни целочислени числа:");
			a1 = Integer.parseInt(sc.nextLine());
			a2 = Integer.parseInt(sc.nextLine());
			a3 = Integer.parseInt(sc.nextLine());
		}
		System.out.printf("a1:%d, a2:%d, a3:%d\n", a1, a2, a3);
		temp1 = a2;
		temp2 = a1;
		a1 = temp1;
		a2 = a3;
		a3 = temp2;
		System.out.printf("a1:%d, a2:%d, a3:%d\n", a1, a2, a3);

	}

}
