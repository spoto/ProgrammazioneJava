import java.util.Set;

public final class Cell extends Exp { // un riferimento a una cella
	private Exp exp;

	protected Cell() {
		this.exp = new StringConstant("");
	} // una cella nasce vuota

	public void setExp(Exp exp) {
		this.exp = exp;
	}

	@Override
	public int getNumericValue(Set<Exp> seen) throws EvaluationException {
		return exp.getNumericValue(seen);
	}

	@Override
	public String getStringValue(Set<Exp> seen) throws EvaluationException {
		return exp.getStringValue(seen);
	}
}