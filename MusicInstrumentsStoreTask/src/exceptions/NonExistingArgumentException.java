package exceptions;

public class NonExistingArgumentException extends Exception {

	private static final long serialVersionUID = 899288537335492838L;

	public NonExistingArgumentException() {
		super();
	}

	public NonExistingArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonExistingArgumentException(String message) {
		super(message);
	}

	public NonExistingArgumentException(Throwable cause) {
		super(cause);
	}
	
}
