public class Task12 {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		// index 0 and 1 with temp variable
		int temp = 0;
		temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
		// index 2 and 3 with addition
		arr[2] = arr[2] + arr[3]; // arr[2] = 3 + 4 = 7
		arr[3] = arr[2] - arr[3]; // arr[3] = 7 - 4 = 3
		arr[2] = arr[2] - arr[3]; // arr[2] = 7 - 3 = 4
		// index 4 and 5 with multiplication
		arr[4] = arr[4] * arr[5]; // arr[4] = 5 * 6 = 30
		arr[5] = arr[4] / arr[5]; // arr[5] = 30 / 6 = 5
		arr[4] = arr[4] / arr[5]; // arr[4] = 30 / 5 = 6
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
}