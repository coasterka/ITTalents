import java.util.Scanner;

public class Task05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int firstNum = 0, secondNum = 0, thirdNum = 0;
		while (firstNum == secondNum || firstNum == thirdNum || secondNum == thirdNum){
			System.out.println("Въведете три различни целочислени числа:");
			firstNum = Integer.parseInt(sc.nextLine());
			secondNum = Integer.parseInt(sc.nextLine());
			thirdNum = Integer.parseInt(sc.nextLine());
		}
		if (firstNum > secondNum && firstNum > thirdNum){
			if (secondNum > thirdNum) {
				System.out.printf("%d %d %d", firstNum, secondNum, thirdNum);
			} 
			else {
				System.out.printf("%d %d %d", firstNum, thirdNum, secondNum);
			}
		}
		else if (secondNum > firstNum && secondNum > thirdNum) {
			if (firstNum > thirdNum) {
				System.out.printf("%d %d %d", secondNum, firstNum, thirdNum);
			}
			else {
				System.out.printf("%d %d %d", secondNum, thirdNum, firstNum);
			}
		}
		else if (thirdNum > firstNum && thirdNum > secondNum) {
			if (firstNum > secondNum) {
				System.out.printf("%d %d %d", thirdNum, firstNum, secondNum);
			}
			else { 
				System.out.printf("%d %d %d", thirdNum, secondNum, firstNum);
			}
		}
	}

}
