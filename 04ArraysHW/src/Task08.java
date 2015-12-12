public class Task08 {
	
	public static void main(String[] args) {
		int[] arr = {4, 4, 4, 4, 1, 3, 3, 3, 2, 2};
		int count = 1;
		int maxCount = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i+1]) {
				count++;
			}
			else {
				count = 1;
			}
			if (count > maxCount) {
				maxCount = count;
			}
		}
		System.out.println(maxCount);
	}
}