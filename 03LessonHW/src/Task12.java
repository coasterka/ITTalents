
public class Task12 {
	public static void main(String[] args) {
		// digits
		int a, b, c;
		for (int i = 100; i <= 999; i++) {
			a = (i % 1000) / 100;
			b = (i % 100) / 10;
			c = i % 10;
			if (a != b && a != c && b != c) {
				System.out.println(i);
			}
		}
	}
}
