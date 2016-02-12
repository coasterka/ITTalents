package threadpool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoThreadPool {
	
	private static final int NUMBER_OF_THREADS = 5;
	private static final int TEXT_PARTS_COUNT = 5;
	private static final String WAR_PEACE_FILE = "war_peace.txt";

	public static void main(String[] args) throws Exception {
		
		int commasCount = 0;
		
		ExecutorService threadPool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		
		Scanner sc = new Scanner(new File(WAR_PEACE_FILE));
		StringBuilder sb = new StringBuilder();

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			sb.append(line);
			sb.append("\n");
		}
		sc.close();

		String fullText = sb.toString();

		int textPartLength = fullText.length() / TEXT_PARTS_COUNT;

		ArrayList<String> textParts = (ArrayList<String>) splitEqually(fullText, textPartLength);
		
		long startTimer = System.currentTimeMillis();
		
		List<Future<Integer>> futureCommasCount = new ArrayList<Future<Integer>>();
		
		for (String textPart : textParts) {
			Future<Integer> futureCommaCount = threadPool.submit(new Counter(textPart));
			futureCommasCount.add(futureCommaCount);
		}

		for (Future<Integer> futureCommaCount : futureCommasCount) {
			commasCount += futureCommaCount.get();
		}
		
		long endTimer = (System.currentTimeMillis() - startTimer);
		
		System.out.println("All commas: " + commasCount);
		
		System.out.println("Time to count with thread pool: " + endTimer);
		
		threadPool.shutdown();
		
	}
	
	public static List<String> splitEqually(String text, int size) {
		List<String> result = new ArrayList<String>((text.length() + size - 1) / size);

		for (int start = 0; start < text.length(); start += size) {
			result.add(text.substring(start, Math.min(text.length(), start + size)));
		}

		if (result.size() > TEXT_PARTS_COUNT) {
			String smallPart = result.get(TEXT_PARTS_COUNT);
			String bigPart = result.get(TEXT_PARTS_COUNT - 1);
			bigPart += smallPart;
			result.remove(TEXT_PARTS_COUNT);
			result.remove(TEXT_PARTS_COUNT - 1);
			result.add(TEXT_PARTS_COUNT - 1, bigPart);
		}
		return result;
	}
}
