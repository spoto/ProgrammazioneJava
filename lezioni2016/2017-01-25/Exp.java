import java.util.HashSet;
import java.util.Set;

public abstract class Exp {
	public abstract int getNumericValue(Set<Exp> seen) throws EvaluationException;

	public abstract String getStringValue(Set<Exp> seen) throws EvaluationException;

	@Override
	public final String toString() {
		try {
			return getStringValue(new HashSet<Exp>());
		}
		catch (CyclicalEvaluationException e) {
			return "@@@";
		}
		catch (EvaluationException e) {
			return "###";
		}
	}
}