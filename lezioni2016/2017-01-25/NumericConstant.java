import java.util.Set;

public class NumericConstant extends Exp { // costante numerica
	private final int value;

	public NumericConstant(int value) {
		this.value = value;
	}
	
	@Override
	public int getNumericValue(Set<Exp> seen) throws EvaluationException {
		return value;
	}

	@Override
	public String getStringValue(Set<Exp> seen) throws EvaluationException {
		return String.valueOf(value);
	}
}