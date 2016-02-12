package fivethreads;

public class Counter implements Runnable {

	private String textToRead;
	private int commasCount;

	public Counter(String textToRead) throws Exception {
		setTextToRead(textToRead);
		this.commasCount = 0;
	}

	@Override
	public void run() {
		String text = this.textToRead;
		for (int i = 0; i < textToRead.length(); i++) {
			if (text.charAt(i) == ',') {
				this.commasCount++;
			}
		}
		System.out.println(Thread.currentThread().getName() + " - Commas count: " + this.commasCount);		
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
