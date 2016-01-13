import java.util.Scanner;
import java.lang.Exception;

public class SecuredNotepad extends Notepad {
	
	private static final int MAX_PASSWORD_ATTEMPTS = 3;
	private static final int MIN_PASSWORD_LENGTH = 5;
	
	private static Scanner sc = new Scanner(System.in);
	private String password;
	
	public SecuredNotepad(Page[] pages, int pagesCount) {
		super(pages, pagesCount);
		setPassword(password);
	}
	
	public SecuredNotepad(Page[] pages, int pagesCount, String paperType, boolean isPaperSquared, String password) {
		super(pages, pagesCount, paperType, isPaperSquared);
		setPassword(password);
	}
	
	@Override
	public void addTextToPageNumber(String text, int pageNumber) {
		System.out.println("Add text to page number: " + pageNumber);
		askForPassword();
		super.addTextToPageNumber(text, pageNumber);
	}

	@Override
	public void deleteTextAndAddNewTextToPageNumber(String text, int pageNumber) {
		System.out.println("Delete text and add new text to page number: " + pageNumber);
		askForPassword();
		super.deleteTextAndAddNewTextToPageNumber(text, pageNumber);
	}

	@Override
	public void deleteTextFromPageNumber(int pageNumber) {
		System.out.println("Delete text from page number: " + pageNumber);
		askForPassword();
		super.deleteTextFromPageNumber(pageNumber);
	}

	@Override
	public void previewAllPages() {
		System.out.println("Preview all pages");
		askForPassword();
		super.previewAllPages();
	}
	
	@Override
	public void searchWord(String word) {
		askForPassword();
		super.searchWord(word);
	}

	@Override
	public void printAllPagesWithDigits() {
		askForPassword();
		super.printAllPagesWithDigits();
	}

	protected void askForPassword() {
		String userPassword = "";
		int countOfPasswordAttempts = 0;
		System.out.println("Enter password:");
		userPassword = sc.nextLine();
		while (!userPassword.equals(this.password)) {
			countOfPasswordAttempts++;
			if (countOfPasswordAttempts < MAX_PASSWORD_ATTEMPTS) {			
				System.out.println("Invalid password! Left attempts: " + 
									(MAX_PASSWORD_ATTEMPTS - countOfPasswordAttempts));
				userPassword = sc.nextLine();
			}
			else {
				//System.out.println("No more password attempts! Aborting method!");
				throw new SecurityException("No more password attempts! Aborting method!");
			}
		}
	}
	// v tozi metod karame user-a mnogokratno da vuvede silna parola
	// dokato ne postigne uspeh, kakto e v povecheto realni sistemi
	private void setPassword(String password) {
		System.out.println("Create password for the secured notepad:");
		password = sc.nextLine();
		
		while (password.isEmpty()) {
			System.out.println("Password can not be empty! Try again:");
			password = sc.nextLine();
		}
		
		boolean isLongEnough = password.length() < MIN_PASSWORD_LENGTH;
		boolean hasUppercase = !password.equals(password.toLowerCase());
		boolean hasLowercase = !password.equals(password.toUpperCase());
		boolean hasDigit = password.matches(".*\\d+.*");

		while (isLongEnough || !hasUppercase || !hasLowercase || !hasDigit) {
			if (isLongEnough) {
				System.out.println("Password must be at least "
						+ MIN_PASSWORD_LENGTH + " characters long!");
			}
			if (!hasUppercase || !hasLowercase || !hasDigit){
				System.out.println("Password must have at least one digit, one uppercase and one "
						+ "lowercase character!");
			}
			password = sc.nextLine();
			// set the boolean values again for every new attempt
			isLongEnough = password.length() < MIN_PASSWORD_LENGTH;
			hasUppercase = !password.equals(password.toLowerCase());
			hasLowercase = !password.equals(password.toUpperCase());
			hasDigit = password.matches(".*\\d+.*");
		}
		this.password = password;
	}
}