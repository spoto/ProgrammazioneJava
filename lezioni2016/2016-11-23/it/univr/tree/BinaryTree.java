package it.univr.tree;

public class BinaryTree {
	private int value;
	private BinaryTree left;
	private BinaryTree right;

	public BinaryTree(int value, BinaryTree left, BinaryTree right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public BinaryTree(int value) {
		this(value, null, null);
	}

	public String toString() {
		return toString("");
	}

	/**
	 * Metodo ausiliario ricorsivo che stampa l'albero
	 * mettendo alla sua sinistra gli spazi passati come
	 * argomento.
	 * 
	 * @param spaces gli spazi
	 * @return la stringa risultante
	 */
	private String toString(String spaces) {
		if (left == null && right == null) {
			// non ci sono sottoalberi
			return spaces + value;
		}
		else if (left == null) {
			// esiste solo il sottoalbero destro
			return right.toString("  " + spaces) + "\n"
					+ spaces + value;
		}
		else if (right == null) {
			// esiste solo il sottoalbero sinistro
			return spaces + value + "\n"
				+ left.toString("  " + spaces);
		}
		else {
			// esistono entrambi i sottoalberi
			return right.toString("  " + spaces) + "\n"
					+ spaces + value + "\n"
					+ left.toString("  " + spaces);
		}
	}

	public int min() {
		if (left == null && right == null) {
			// non ci sono sottoalberi
			return value;
		}
		else if (left == null) {
			// esiste solo il sottoalbero destro
			int minRight = right.min();
			return Math.min(value, minRight);
		}
		else if (right == null) {
			// esiste solo il sottoalbero sinistro
			int minLeft = left.min();
			return Math.min(value, minLeft);
		}
		else {
			// esistono entrambi i sottoalberi
			int minLeft = left.min();
			int minRight = right.min();
			return Math.min(value, Math.min(minLeft, minRight));
		}
	}

	public int max() {
		if (left == null && right == null) {
			// non ci sono sottoalberi
			return value;
		}
		else if (left == null) {
			// esiste solo il sottoalbero destro
			int maxRight = right.max();
			return Math.max(value, maxRight);
		}
		else if (right == null) {
			// esiste solo il sottoalbero sinistro
			int maxLeft = left.max();
			return Math.max(value, maxLeft);
		}
		else {
			// esistono entrambi i sottoalberi
			int maxLeft = left.max();
			int maxRight = right.max();
			return Math.max(value, Math.max(maxLeft, maxRight));
		}
	}

	public int sum() {
		if (left == null && right == null) {
			// non ci sono sottoalberi
			return value;
		}
		else if (left == null) {
			// esiste solo il sottoalbero destro
			int sumRight = right.sum();
			return value + sumRight;
		}
		else if (right == null) {
			// esiste solo il sottoalbero sinistro
			int sumLeft = left.sum();
			return value + sumLeft;
		}
		else {
			// esistono entrambi i sottoalberi
			int sumLeft = left.sum();
			int sumRight = right.sum();
			return value + sumLeft + sumRight;
		}
	}
}
