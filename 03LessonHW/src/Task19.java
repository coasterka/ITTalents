import java.util.Scanner;

public class Task19 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете естествено число от интервала [10.. 99]:");		
		int num = Integer.parseInt(sc.nextLine());
		int temp = num;
		while (temp >= 1) {
			int i = temp;			
			if (i == num) {
				if (i % 2 == 0){
					temp = (int) (num * 0.5);
				}
				else if (i % 2 == 1) {
					temp = (3 * num) + 1;
				}
			}
			else {
				if (temp == 1){
					break;
				}
				else {
					if (temp % 2 == 0) {
						temp = (int) (temp * 0.5);
					}
					else if (temp % 2 == 1) {
						temp = (3 * temp) + 1;
					}
				}
			}
			System.out.print(temp + " ");
			i--;
		}
	}
}