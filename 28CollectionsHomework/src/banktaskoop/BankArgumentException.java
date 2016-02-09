package banktaskoop;

public class BankArgumentException extends Exception {
	
	private static final long serialVersionUID = -5443412337621404562L;

	public BankArgumentException() {
		super();
	}

	public BankArgumentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BankArgumentException(String arg0) {
		super(arg0);
	}

	public BankArgumentException(Throwable arg0) {
		super(arg0);
	}
}
