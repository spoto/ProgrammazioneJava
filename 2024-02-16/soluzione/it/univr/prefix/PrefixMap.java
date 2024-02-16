package it.univr.prefix;

import java.util.ArrayList;
import java.util.List;

public class PrefixMap<E> {
	private Node<E> root;

	// lega value alla chiave key
	public void put(String key, E value) {
		if (key == null)
			throw new NullPointerException("null keys are not allowed");

		if (root == null)
			root = new Leaf<E>(key, value);
		else
			root = root.put(key, value);
	}

	// restituisce il valore a cui è legata la chiave key, se esiste,
	// altrimenti ritorna null
	public E get(String key) {
		return root == null ? null : root.get(key);
	}

	// restituisce una rappresentazione stringa dell'albero di prefissi
	public String toString() {
		return root == null ? "" : root.toString("");
	}

	// un nodo dell'albero dei prefissi
	private interface Node<E> {
		// restituisce il suo prefisso
		String getPrefix();

		// lega un valore alla data chiave a partire da questo nodo
		Node<E> put(String key, E value);

		// cerca il valore legato alla chiave indicata, a partire da questo nodo
		E get(String key);

		// restituisce una rappresentazione stringa di questo nodo e dei suo figli, ricorsivamente
		String toString(String nesting);
	}

	// implementazione comune dei nodi
	private abstract static class AbstractNode<E> implements Node<E> {
		protected final String prefix;

		protected AbstractNode(String prefix) {
			this.prefix = prefix;
		}

		@Override
		public String getPrefix() {
			return prefix;
		}
	}

	// un nodo foglia, quindi con un valore e senza figli
	private static class Leaf<E> extends AbstractNode<E> {
		private final E value;

		private Leaf(String prefix, E value) {
			super(prefix);
			this.value = value;
		}

		@Override
		public Node<E> put(String key, E value) {
			if (key.equals(prefix))
				return new Leaf<E>(key, value);
			else {
				String commonPrefix = commonPrefix(prefix, key);
				List<Node<E>> children = new ArrayList<Node<E>>();
				children.add(new Leaf<E>(prefix.substring(commonPrefix.length()), this.value));
				children.add(new Leaf<E>(key.substring(commonPrefix.length()), value));
				return new Internal<E>(commonPrefix, children);
			}
		}

		@Override
		public String toString(String nesting) {
			return nesting + "\"" + prefix + "\": " + value + "\n";
		}

		@Override
		public E get(String key) {
			// se la chiave che cerchiamo coincide con il nostro prefisso,
			// allora abbiamo trovato il valore associato
			return key.equals(prefix) ? value : null;
		}
	}

	// un nodo interno, quindi con dei figli ma senza un valore
	private static class Internal<E> extends AbstractNode<E> {
		private final List<Node<E>> children;

		private Internal(String prefix, List<Node<E>> children) {
			super(prefix);
			this.children = children;
		}

		@Override
		public Node<E> put(String key, E value) {
			String commonPrefix = commonPrefix(prefix, key);
			if (commonPrefix.length() < prefix.length()) {
				List<Node<E>> children = new ArrayList<Node<E>>();
				children.add(new Internal<E>(prefix.substring(commonPrefix.length()), this.children));
				children.add(new Leaf<E>(key.substring(commonPrefix.length()), value));
				return new Internal<E>(commonPrefix, children);
			}
			else { // commonPrefix.equals(prefix)
				List<Node<E>> children = new ArrayList<Node<E>>();
				String remainingPrefix = key.substring(prefix.length());
				boolean done = false;
				for (Node<E> child: this.children)
					if (!commonPrefix(remainingPrefix, child.getPrefix()).isEmpty()) {
						children.add(child.put(remainingPrefix, value));
						done = true;
					}
					else
						children.add(child);

				if (!done)
					children.add(new Leaf<E>(remainingPrefix, value));

				return new Internal<E>(commonPrefix, children);
			}
		}

		@Override
		public String toString(String nesting) {
			String result = "", nextNesting = nesting + "    ";
			int n = 0, numChildren = children.size();

			while (n < numChildren / 2)
				result += children.get(n++).toString(nextNesting);

			result += nesting + "\"" + prefix + "\"\n";

			while (n < numChildren)
				result += children.get(n++).toString(nextNesting);

			return result;
		}

		@Override
		public E get(String key) {
			if (key.startsWith(prefix)) {
				// se la chiave che cerchiamo inizia con il prefisso
				// in questo nodo, allora togliamo il prefisso e continuiamo
				// a cercare la parte restante della chiave a partire dai
				// nostri figli
				String keyWithoutPrefix = key.substring(prefix.length());
				for (Node<E> child: children) {
					E result = child.get(keyWithoutPrefix);
					if (result != null)
						return result; // trovata
				}
			}

			return null;
		}
	}

	private static String commonPrefix(String s1, String s2) {
		String prefix = "";
		for (int pos = 0; pos < s1.length() && pos < s2.length() && s1.charAt(pos) == s2.charAt(pos); pos++)
			prefix += s1.charAt(pos);

		return prefix;
	}
}
