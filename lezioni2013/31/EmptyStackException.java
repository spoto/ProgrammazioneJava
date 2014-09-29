
public class EmptyStackException extends Exception {

	public EmptyStackException(String message) {
		super(message);
	}

	public EmptyStackException() {
		super("empty stack");
	}
}
