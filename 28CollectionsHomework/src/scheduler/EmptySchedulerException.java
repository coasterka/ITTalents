package scheduler;

public class EmptySchedulerException extends Exception {

	private static final long serialVersionUID = 4878497167334697854L;

	public EmptySchedulerException() {
		super();
	}

	public EmptySchedulerException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptySchedulerException(String message) {
		super(message);
	}

	public EmptySchedulerException(Throwable cause) {
		super(cause);
	}
	
}
