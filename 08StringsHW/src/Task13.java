public class Task13 {
	
	static int[] combineArrays(int[] arr1, int[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		int newLen = len1 + len2;
		int[] newArr = new int[newLen];
		// while
		return newArr;
	}
	
	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 11, 22, 33, 44, 55 };
		int[] newArr = combineArrays(arr1, arr2);
		printArray(newArr);
	}
}