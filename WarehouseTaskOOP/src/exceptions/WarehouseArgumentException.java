package exceptions;

public class WarehouseArgumentException extends Exception {
	
	private static final long serialVersionUID = -2613722920914517758L;

	public WarehouseArgumentException() {
		super();
	}

	public WarehouseArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public WarehouseArgumentException(String message) {
		super(message);
	}

	public WarehouseArgumentException(Throwable cause) {
		super(cause);
	}
	
}
