import java.util.Scanner;

public class Task10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int smallBucket = 2, largeBucket = 3;
		int extraBucket = 0;
		int capacity = 0;
		int count = 0;
		String result = "";
		while (capacity < 10 || capacity > 9999) {
			System.out.println("Въведете естествено число [10.. 9999] за литри:");
			capacity = Integer.parseInt(sc.nextLine());
		}
		count = capacity / (smallBucket + largeBucket);
		extraBucket = capacity - (count * (smallBucket + largeBucket));
		if (extraBucket == 1) {
			count--;
			extraBucket += (smallBucket + largeBucket);
		}
		System.out.printf("%d пъти по %d литра,\n", count, smallBucket);
		System.out.printf("%d пъти по %d литра\n", count, largeBucket);
		if (extraBucket != 0){
			result += "допълнително ";
			switch (extraBucket) {
			case 2:
				result += "кофа от 2 литра.";
				break;
			case 3:
				result += "кофа от 3 литра.";
				break;
			case 4:
				result += "2 кофи от 2 литра.";
				break;
			case 6:
				result += "2 кофи от 3 литра.";
				break;
			default:
				break;
			}
			System.out.println(result);
		}
	}

}
