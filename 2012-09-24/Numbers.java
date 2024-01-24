
public abstract class Numbers implements Iterable<Integer> {
	
	@Override
	public final String toString() {
		String result = "";

		for (Integer i: this)
			result += i + " ";

		return result;
	}
}