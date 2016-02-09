package scheduler;

public class TaskAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 8039819269020633872L;

	public TaskAlreadyExistsException() {
		super();
	}

	public TaskAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public TaskAlreadyExistsException(String message) {
		super(message);
	}

	public TaskAlreadyExistsException(Throwable cause) {
		super(cause);
	}
	
}
