package banktaskoop;

public class ClientException extends Exception {

	private static final long serialVersionUID = -4653744711125371883L;

	public ClientException() {
		super();
	}

	public ClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClientException(String message) {
		super(message);
	}

	public ClientException(Throwable cause) {
		super(cause);
	}
}
