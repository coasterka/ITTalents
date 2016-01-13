
public abstract class Notepad implements INotepad {
	private Page[] pages;
	private int pagesCount;
	private String paperType;
	private boolean isPaperSquared;

	public Notepad(Page[] pages, int pagesCount) {
		setPagesCount(pagesCount);
		this.pages = new Page[pagesCount];
		addPagesToNotepad(pages);
		this.paperType = "White paper";
		this.isPaperSquared = false;
	}
	
	public Notepad(Page[] pages, int pagesCount, String paperType, boolean isPaperSquared) {
		this(pages, pagesCount);
		setPaperType(paperType);
		this.isPaperSquared = isPaperSquared;
	}
	
	@Override
	public void addTextToPageNumber(String text, int pageNumber) {
		Page workingPage = checkPageValidity(pageNumber);
		workingPage.addText(text);
		System.out.println("Text added to page: " + pageNumber);
	}

	@Override
	public void deleteTextAndAddNewTextToPageNumber(String text, int pageNumber) {
		Page workingPage = checkPageValidity(pageNumber);
		workingPage.deleteText();
		workingPage.addText(text);
		System.out.println("Old text deleted, new text added to page: " + pageNumber);
	}

	@Override
	public void deleteTextFromPageNumber(int pageNumber) {
		Page workingPage = checkPageValidity(pageNumber);
		workingPage.deleteText();
		System.out.println("Text deleted from page: " + pageNumber);
	}

	@Override
	public void previewAllPages() {
		for (int i = 0; i < pages.length; i++) {
			if (pages[i] != null) {
				//Page currentPage = checkPageValidity(i+1);
				//currentPage.preview();
				pages[i].preview();
			}
		}		
	}
	
	@Override
	public void searchWord(String word) {
		for (int i = 0; i < pages.length; i++) {
			if (pages[i].searchWord(word)) {
				System.out.println("Word \"" + word + "\" found on page: " + (i+1));
				return;
			}
			if (i == pages.length - 1) {
				System.out.println("Word \"" + word + "\" not found!");
			}
		}
	}

	@Override
	public void printAllPagesWithDigits() {
		for (int i = 0; i < pages.length; i++) {
			if (pages[i] != null) {
				if (pages[i].containsDigits()) {
					pages[i].preview();
				}
			}
		}		
	}

	private void isPageNull(Page page) {
		if (page == null) {
//			throw new IllegalArgumentException("Page can not be null!");
			System.out.println("Page is null!");
			return;
		}
	}
	
	private Page checkPageValidity(int pageNumber) {
		Page workingPage = pages[pageNumber-1];
		isPageNull(workingPage);
		return workingPage;
	}
	
	private void addPagesToNotepad(Page[] pages) {
		for (int i = 0; i < pages.length; i++) {
			if (pages[i] != null) {
				this.pages[i] = pages[i];
			}
		}
	}
	
	private void setPagesCount(int pagesCount) {
		if (pagesCount <= 0) {
			throw new IllegalArgumentException("Pages count can not be negative or = 0!");
		}
		this.pagesCount = pagesCount;
	}

	public void setPaperType(String paperType) {
		if (paperType == null || paperType.isEmpty()) {
			throw new IllegalArgumentException("Paper type can not be null or empty!");
		}
		this.paperType = paperType;
	}
	
}
