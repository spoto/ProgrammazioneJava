package it.univr.musica;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class CanzoneImpl extends AbstractCanzone {
	private final String nome;
	private final List<Nota> note = new ArrayList<Nota>();

	public CanzoneImpl(String nome, Nota... note) {
		this.nome = nome;

		for (Nota nota: note)
			this.note.add(nota);
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public Iterator<Nota> iterator() {
		return note.iterator();
	}
}