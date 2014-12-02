package it.univr.circuit;

public abstract class BinOp extends Circuit {

	private Circuit left;
	private Circuit right;

	public BinOp(Circuit left, Circuit right) {
		this.left = left;
		this.right = right;
	}

	protected Circuit getLeft() {
		return left;
	}

	protected Circuit getRight() {
		return right;
	}

	@Override
	public Variable[] freeVariables() {
		Variable[] vleft = left.freeVariables();
		Variable[] vright = right.freeVariables();

		// calcolo lunghezza del risultato
		int len = vleft.length;
		for (Variable v: vright) {
			boolean ripetizione = false;
			for (Variable w: vleft)
				if (v.getName().equals(w.getName()))
					ripetizione = true;

			if (!ripetizione)
				len++;
		}

		// creo array di variabili di tale lunghezza
		Variable[] result = new Variable[len];
		
		// lo riempio con vleft
		int pos = 0;
		for (Variable v: vleft)
			result[pos++] = v;
		
		// lo completo con gli elementi di vright non in vleft
		for (Variable v: vright) {
			boolean ripetizione = false;
			for (Variable w: vleft)
				if (v.getName().equals(w.getName()))
					ripetizione = true;

			if (!ripetizione)
				result[pos++] = v;
		}

		return result;
	}
}
