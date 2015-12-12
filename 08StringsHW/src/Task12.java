public class Task12 {
	
	static int[] numbersInRange(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1; // [1.. n]
		}
		return arr;
	}
	// using the function from task 11 to check the result
	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		printArray(numbersInRange(6));
	}
}
