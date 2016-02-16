package exceptions;

public class NotEnoughQuantityException extends Exception {

	private static final long serialVersionUID = 1009802488738706895L;

	public NotEnoughQuantityException() {
		super();
	}

	public NotEnoughQuantityException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotEnoughQuantityException(String message) {
		super(message);
	}

	public NotEnoughQuantityException(Throwable cause) {
		super(cause);
	}
	
}
