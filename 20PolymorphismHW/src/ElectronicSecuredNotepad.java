
public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice {

	private boolean isStarted;
	
	public ElectronicSecuredNotepad(Page[] pages, int pagesCount) {
		super(pages, pagesCount);
		this.isStarted = false;
	}

	@Override
	public void start() {
		System.out.println("Turning ESN on:");
		askForPassword();
		System.out.println("ESN has just been turned on!");
		this.isStarted = true;
	}

	@Override
	public void stop() {
		System.out.println("ESN has just been turned off!");
		this.isStarted = false;		
	}

	@Override
	public boolean isStarted() {
		if (!isStarted) {
			throw new IllegalMonitorStateException("The notepad must be started in order to work!");
		}
		else {
			return true;
		}
	}

	@Override
	public void addTextToPageNumber(String text, int pageNumber) {
		isStarted();
		super.addTextToPageNumber(text, pageNumber);
	}

	@Override
	public void deleteTextAndAddNewTextToPageNumber(String text, int pageNumber) {
		isStarted();
		super.deleteTextAndAddNewTextToPageNumber(text, pageNumber);
	}

	@Override
	public void deleteTextFromPageNumber(int pageNumber) {
		isStarted();
		super.deleteTextFromPageNumber(pageNumber);
	}

	@Override
	public void previewAllPages() {
		isStarted();
		super.previewAllPages();
	}

	@Override
	public void searchWord(String word) {
		isStarted();
		super.searchWord(word);
	}

	@Override
	public void printAllPagesWithDigits() {
		isStarted();
		super.printAllPagesWithDigits();
	}
}
