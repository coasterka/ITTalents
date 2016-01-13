import org.omg.CORBA.Environment;

public class Page {
	private String title;
	private String text;
	
	public Page(String title, String text) {
		setTitle(title);
		setText(text);
	}
	
	public boolean searchWord(String word) {
		String[] words = this.text.split("([\\W]+)");
		boolean containsWord = false;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equalsIgnoreCase(word)) {
				containsWord = true;
				break;
			}
			if (i == words.length - 1) {
				return containsWord;
			}
		}
		// useless printing?
		if (containsWord) {
			System.out.println("Word \"" + word + "\" found!");
		}
		return containsWord;
	}
	
	public boolean containsDigits() {
		boolean containsDigits = false;
		if (this.text.matches(".*\\d+.*")) {
			//System.out.println("Text contains digits!");
			containsDigits = true;
		}
//		else {
//			System.out.println("Text doesn't contain digit!");
//		}
		return containsDigits;
	}
	
	public void addText(String newText) {
		this.isTextNull();
		if (newText == null || newText.isEmpty()) {
			throw new IllegalArgumentException("Can not add null or empty text!");
		}
		this.text += " " + newText;
	}
	
	public void deleteText() {
		this.isTextNull();
		this.text = "";
	}
	
	public void preview() {
//		this.isTitleNull();
//		this.isTextNull();
		if (this.title == null) {
			System.out.println("Null title");
			return;
		}
		if (this.text == null) {
			System.out.println("Null text");
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(this.title);
		sb.append(": ");
		sb.append(this.text);
		sb.append("\n");
		System.out.println(sb.toString());
	}
	
	public void isTextNull() {
		if (this.text == null) {
			throw new IllegalArgumentException("Page text is null!");
		}
	}
	
	public void isTitleNull() {
		if (this.title == null) {
			throw new IllegalArgumentException("Page title is null!");
		}
	}
	
	private void setTitle(String title) {
		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Title can not be null or empty!");
		}
		this.title = title;
	}
	
	private void setText(String text) {
		if (text == null) {
			throw new IllegalArgumentException("Text can not be null!");
		}
		this.text = text;
	}
}
