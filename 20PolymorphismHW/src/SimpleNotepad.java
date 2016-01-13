
public class SimpleNotepad extends Notepad {

	public SimpleNotepad(Page[] pages, int pagesCount) {
		super(pages, pagesCount);
	}
	
	public SimpleNotepad(Page[] pages, int pagesCount, String paperType, boolean isPaperSquared) {
		super(pages, pagesCount, paperType, isPaperSquared);
	}
}
