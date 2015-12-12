public class Task14 {
	// 5! = 5 * 4 * 3 * 2 * 1
	static long nFactoriel(int n) {
		if (n <= 1) {
			return 1;
		}
		return nFactoriel(n - 1) * n;
	}
	
	public static void main(String[] args) {
		System.out.println(nFactoriel(5));
	}
}