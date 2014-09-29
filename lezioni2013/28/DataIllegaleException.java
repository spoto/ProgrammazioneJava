
public class DataIllegaleException extends Exception {

	public DataIllegaleException(String messaggio) {
		super(messaggio);
	}

	public DataIllegaleException() {
		super("data illegale");
	}
}
 