public class Task02 {
	
	public static void main(String[] args) {
		int[] arr = {3, 6, 7, 8, 9, 10};
		int[] newArr = new int[arr.length];
		int i = 0;
		int j = 0;
		while(i < arr.length) {
			// i between [0.. 4]
			if (i < arr.length / 2) {
				newArr[i] = arr[i];
				i++;
				j++;
			}
			// i between [5..9]
			else if (i >= arr.length / 2) {
				j--;
				newArr[i] = arr[j];
				i++;				
			}
		}
		for (int index = 0; index < newArr.length; index++) {
			System.out.print(newArr[index] + " ");
		}
	}
}
