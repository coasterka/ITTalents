package exceptions;

public class NonExistingProductException extends Exception {

	private static final long serialVersionUID = 7563748998110547886L;

	public NonExistingProductException() {
		super();
	}

	public NonExistingProductException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonExistingProductException(String message) {
		super(message);
	}

	public NonExistingProductException(Throwable cause) {
		super(cause);
	}	
}
