package tp.p2.Exceptions;

public class FileContentsException extends Exception{

	
	private static final long serialVersionUID = 1L;

	public FileContentsException() {
		super();
	}
	
	public FileContentsException(String message) {
		super(message);
	}
	
	public FileContentsException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
