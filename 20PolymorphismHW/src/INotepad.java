
public interface INotepad {
	void addTextToPageNumber(String text, int pageNumber);
	void deleteTextAndAddNewTextToPageNumber(String text, int pageNumber);
	void deleteTextFromPageNumber(int pageNumber);
	void previewAllPages();
	void searchWord(String word);
	void printAllPagesWithDigits();
}
