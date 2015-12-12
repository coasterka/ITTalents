public class Task11 {
	
	public static void main(String[] args) {
		int[] numArr = { 5, 2, 6, 2, 5, 7, 30 };
		printArray(numArr);
	}
	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}