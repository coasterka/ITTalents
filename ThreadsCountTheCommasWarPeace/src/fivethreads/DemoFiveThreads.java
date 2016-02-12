package fivethreads;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoFiveThreads {

	private static final int TIME_TO_SLEEP_WHILE_COUNTING = 20;
	private static final int TEXT_PARTS_COUNT = 5;
	private static final int NUMBER_OF_THREADS = TEXT_PARTS_COUNT;
	private static final String WAR_PEACE_FILE = "war_peace.txt";

	public static void main(String[] args) throws Exception {

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

		int threadNameCounter = 1;
		int allCommasCount = 0;

		long startTimer = System.currentTimeMillis();
		
		for (String textPart : textParts) {
			Counter counter = new Counter(textPart);
			Thread counterThread = new Thread(counter, "Counter " + (threadNameCounter++));
			counterThread.start();
			// put the thread to sleep so we can count the commas
			Thread.sleep(TIME_TO_SLEEP_WHILE_COUNTING);
			allCommasCount += counter.getCommasCount();
		}

		System.out.println("All commas count: " + allCommasCount);

		long endTimer = (System.currentTimeMillis() - startTimer);

		System.out.println("Time to count with " + NUMBER_OF_THREADS + " threads: " + endTimer);
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
