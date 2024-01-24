
public class InconsistentSampleSizeException extends Exception {
	public InconsistentSampleSizeException(int size) {
		super(String.valueOf(size));
	}
}
