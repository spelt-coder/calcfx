package application;

public class SyntaxException extends RuntimeException {

	public SyntaxException() {
		super("Syntax error");
	}

	public SyntaxException(String message) {
		super(message);
	}

}
