import java.util.Scanner;

public class Task03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int firstNum = 0, secondNum = 0;
		int temp = 0;
		while (firstNum == secondNum){
			System.out.println("Въведете две различни целочислени числа:");
			firstNum = Integer.parseInt(sc.nextLine());
			secondNum = Integer.parseInt(sc.nextLine());
		}
		System.out.printf("Вашите числа са:\nA: %d\nB: %d\n",
				firstNum, secondNum);
		temp = firstNum;
		firstNum = secondNum;
		secondNum = temp;
		System.out.printf("Разменени стойности:\nA: %d\nB: %d\n",
				firstNum, secondNum);
	}
}