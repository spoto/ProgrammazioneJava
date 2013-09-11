package it.univr.musica;

import java.util.Iterator;

public class CanzoneRibasata extends AbstractCanzone {
	private final Canzone base;
	private final int inc;

	public CanzoneRibasata(Canzone base, int inc) {
		this.base = base;
		this.inc = inc;
	}

	@Override
	public Iterator<Nota> iterator() {
		return new Iterator<Nota>() {

			private final Iterator<Nota> it = base.iterator();

			@Override
			public boolean hasNext() {
				return it.hasNext();
			}

			@Override
			public Nota next() {
				return it.next().incrementa(inc);
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public String getNome() {
		return base.getNome();
	}
}