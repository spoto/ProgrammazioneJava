import java.util.Set;

public class StringConstant extends Exp { // costante stringa
	private final String value;

	public StringConstant(String value) {
		this.value = value;
	}

	@Override
	public int getNumericValue(Set<Exp> seen) throws EvaluationException {
		try {
			return Integer.parseInt(value);
		}
		catch (NumberFormatException e) {
			throw new EvaluationException();
		}
	}

	@Override
	public String getStringValue(Set<Exp> seen) throws EvaluationException {
		return value;
	}
}