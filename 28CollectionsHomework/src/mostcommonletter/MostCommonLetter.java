package mostcommonletter;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class MostCommonLetter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter some text: ");
		String workingString = sc.nextLine().replaceAll("([.!? ]+)", "").toLowerCase();
		TreeMap<Character, Integer> lettersWithCount = new TreeMap<Character, Integer>();
		
		for (char letter : workingString.toCharArray()) {
			int countOfLetter = 1;
			if (!lettersWithCount.keySet().contains(letter)) {
				lettersWithCount.put(letter, countOfLetter++);
			}
			else {
				lettersWithCount.put(letter, lettersWithCount.get(letter)+1);
			}
		}
		
		List<Entry<Character, Integer>> sortedLettersCount = new ArrayList<Entry<Character, Integer>>(lettersWithCount.entrySet());
		
		Collections.sort(sortedLettersCount, new Comparator<Entry<Character, Integer>>() {
		    @Override
		    public int compare(Entry<Character, Integer> e1, Entry<Character, Integer> e2) {
		        return e2.getValue() - e1.getValue();
		    }
		});
		
		int lettersCount = 0;
		
		for (Entry<Character, Integer> entry : sortedLettersCount) {
			lettersCount += entry.getValue();
		}
		
		for (Entry<Character, Integer> entry : sortedLettersCount) {
			double frequencyPercent = ((double)entry.getValue() / lettersCount) * 100;
			int symbolsCount = (int) (frequencyPercent / entry.getValue()) * entry.getValue();
			System.out.print(entry.getKey().toString().toUpperCase() + ": " + entry.getValue() + " ");
			for (int symbol = 1; symbol <= symbolsCount; symbol++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}
