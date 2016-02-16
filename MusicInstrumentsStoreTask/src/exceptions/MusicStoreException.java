package exceptions;

public class MusicStoreException extends Exception {
	
	private static final long serialVersionUID = -1780032693322838375L;

	public MusicStoreException() {
		super();
	}

	public MusicStoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public MusicStoreException(String message) {
		super(message);
	}

	public MusicStoreException(Throwable cause) {
		super(cause);
	}
	
}
