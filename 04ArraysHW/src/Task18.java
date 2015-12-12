
public class Task18 {
	public static void main(String[] args) {
		int[] arr1 = { 18, 19, 32, 1, 3, 4, 5, 6, 7, 8 };
		int[] arr2 = { 1, 2, 3, 4, 5, 16, 17, 18, 27, 11 };
		if (arr1.length == arr2.length) {
			int[] arr3 = new int[arr1.length];
			int largerNum = 0;
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] > arr2[i]) {
					largerNum = arr1[i];
				}
				else {
					largerNum = arr2[i];
				}
				arr3[i] = largerNum;
			}
			// print the first array
			for (int i = 0; i < arr1.length; i++) {
				System.out.print(arr1[i] + ", ");
			}
			System.out.println();
			// print the second array
			for (int j = 0; j < arr2.length; j++) {
				System.out.print(arr2[j] + ", ");
			}
			System.out.println();
			// print the new array
			for (int k = 0; k < arr3.length; k++) {
				System.out.print(arr3[k] + ", ");
			}
		}
		else {
			System.out.println("Масивите са с различна дължина.");
		}
	}
}
