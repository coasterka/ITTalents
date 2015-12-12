public class Task14 {
	
	public static void main(String[] args) {
		double[] arr = { 7.1, 8.5, 0.2, 3.7, 0.99, 1.4, -3.5, -110, 212, 341, 1.2 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= -2.99 && arr[i] <= 2.99) {
				System.out.print(arr[i] + "; ");
			}
		}
	}
}