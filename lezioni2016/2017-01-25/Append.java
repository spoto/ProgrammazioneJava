import java.util.HashSet;
import java.util.Set;

public class Append extends Exp { // concatenazione fra due espressioni viste come stringa
	private final Exp left;
	private final Exp right;

	public Append(Exp left, Exp right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int getNumericValue(Set<Exp> seen) throws EvaluationException {
		try {
			return Integer.parseInt(getStringValue(seen));
		}
		catch (NumberFormatException e) {
			throw new EvaluationException();
		}
	}

	@Override
	public String getStringValue(Set<Exp> seen) throws EvaluationException {
		if (seen.contains(this)) // se sono già passato da qui
			throw new CyclicalEvaluationException();

		Set<Exp> seenLeft = new HashSet<>(seen);
		Set<Exp> seenRight = new HashSet<>(seen);
		seenLeft.add(this);
		seenRight.add(this);

		return left.getStringValue(seenLeft) + right.getStringValue(seenRight);
	}

}