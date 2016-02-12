package simple;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountTheCommasSimple {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("war_peace.txt"));
		StringBuilder sb = new StringBuilder();
		
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			sb.append(line);
			sb.append("\n");
		}
		sc.close();
		
		String text = sb.toString();
		int commasCount = 0;
		
		long startTimer = System.currentTimeMillis();
		
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ',') {
				commasCount++;
			}
		}
		
		long endTimer = System.currentTimeMillis() - startTimer;
		
		System.out.println("Commas count: " + commasCount);
		System.out.println("Time to count without threads: " + endTimer);
	}
}
