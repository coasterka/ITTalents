import java.util.Scanner;

public class Task02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int firstInt = 0, secondInt = 0;
		double firstDouble = 0, secondDouble = 0;
		int sum, difference, product, restOfDivision, intDivision;
		double sumD, differenceD, productD, restOfDivD, divisionD;
		
		while (firstInt == secondInt){
			System.out.println("Въведете две различни целочислени числа:");
			firstInt = Integer.parseInt(sc.nextLine());
			secondInt = Integer.parseInt(sc.nextLine());
		}
		while (firstDouble == secondDouble){
			System.out.println("Въведете две различни числа с плаваща запетая:");
			firstDouble = Double.parseDouble(sc.nextLine());
			secondDouble = Double.parseDouble(sc.nextLine());
		}
		sum = firstInt + secondInt;
		sumD = firstDouble + secondDouble;
		if (firstInt > secondInt){
			difference = firstInt - secondInt;
			restOfDivision = firstInt % secondInt;
			intDivision = firstInt / secondInt;
			differenceD = firstDouble - secondDouble;
			restOfDivD = firstDouble % secondDouble;
			divisionD = firstDouble / secondDouble;
		} else {
			difference = secondInt - firstInt;
			restOfDivision = secondInt % firstInt;
			intDivision = secondInt / firstInt;
			differenceD = secondDouble - firstDouble;
			restOfDivD = secondDouble % firstDouble;
			divisionD = secondDouble / firstDouble;
		}
		product = firstInt * secondInt;
		productD = firstDouble * secondDouble;
		System.out.println("Действия с целочислени числа:");
		System.out.printf("Сума: %d\nРазлика: %d\nПроизведение: %d\n"
				+ "Остатък от деление: %d\nЦелочислено деление: %d\n",
				sum, difference, product, restOfDivision, intDivision);
		System.out.println("Действия с числа с плаваща запетая:");
		System.out.printf("Сума: %.2f\nРазлика: %.2f\nПроизведение: %.2f\n"
				+ "Остатък от деление: %.2f\nЦелочислено деление: %.2f\n",
				sumD, differenceD, productD, restOfDivD, divisionD);

	}

}
