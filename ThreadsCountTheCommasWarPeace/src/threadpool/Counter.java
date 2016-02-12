package threadpool;

import java.util.concurrent.Callable;

public class Counter implements Callable<Integer> {

	private String textToRead;
	private int commasCount;

	public Counter(String textToRead) throws Exception {
		setTextToRead(textToRead);
		this.commasCount = 0;
	}
	
	@Override
	public Integer call() throws Exception {
		String text = this.textToRead;
		for (int i = 0; i < textToRead.length(); i++) {
			if (text.charAt(i) == ',') {
				this.commasCount++;
			}
		}
		return this.commasCount;
	}

	private void setTextToRead(String textToRead) throws Exception {
		if (textToRead == null || textToRead.isEmpty()) {
			throw new Exception("Working text can not be null or empty!");
		}
		this.textToRead = textToRead;
	}
	
	public int getCommasCount() {
		return this.commasCount;
	}
	
}
