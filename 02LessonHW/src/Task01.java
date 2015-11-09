import java.util.Scanner;

public class Task01 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		double firstNum, secondNum, thirdNum;
		System.out.println("Въведете A:");
		firstNum = Double.parseDouble(sc.nextLine());
		System.out.println("Въведете B:");
		secondNum = Double.parseDouble(sc.nextLine());
		System.out.println("Въведете C:");
		thirdNum = Double.parseDouble(sc.nextLine());
		if ((thirdNum > firstNum && thirdNum < secondNum) ||
			(thirdNum < firstNum && thirdNum > secondNum)){
			System.out.printf("Числото %.1f е между %.1f и %.1f.\n",
					thirdNum, firstNum, secondNum);
		} else {
			System.out.printf("Числото %.1f не е между %.1f и %.1f.\n",
					thirdNum, firstNum, secondNum);
		}
	}
}