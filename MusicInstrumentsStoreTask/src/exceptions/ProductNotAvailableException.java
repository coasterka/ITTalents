package exceptions;

public class ProductNotAvailableException extends Exception {

	private static final long serialVersionUID = -8347560068402647535L;

	public ProductNotAvailableException() {
		super();
	}

	public ProductNotAvailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductNotAvailableException(String message) {
		super(message);
	}

	public ProductNotAvailableException(Throwable cause) {
		super(cause);
	}

}
