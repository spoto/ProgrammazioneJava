import java.util.HashSet;
import java.util.Set;

public class Add extends Exp { // addizione di due espressioni
	private final Exp left;
	private final Exp right;

	public Add(Exp left, Exp right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int getNumericValue(Set<Exp> seen) throws EvaluationException {
		if (seen.contains(this)) // se sono già passato da qui
			throw new CyclicalEvaluationException();

		Set<Exp> seenLeft = new HashSet<>(seen);
		Set<Exp> seenRight = new HashSet<>(seen);
		seenLeft.add(this);
		seenRight.add(this);

		return left.getNumericValue(seenLeft) + right.getNumericValue(seenRight);
	}

	@Override
	public String getStringValue(Set<Exp> seen) throws EvaluationException {
		return String.valueOf(getNumericValue(seen));
	}
}