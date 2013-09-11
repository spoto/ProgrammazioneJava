package it.univr.elezioni;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Coalizione implements Iterable<Partito> {
	private final String nome;

	// i partiti che fanno farte di questa coalizione
	private final Set<Partito> partiti = new HashSet<Partito>();

	public Coalizione(String nome, Partito... partiti) {
		if (partiti.length == 0)
			throw new IllegalArgumentException("Una coalizione non può essere vuota");

		this.nome = nome;

		for (Partito partito: partiti)
			this.partiti.add(partito);
	}

	@Override
	public boolean equals(Object altro) {
		return altro instanceof Coalizione && ((Coalizione) altro).nome.equals(nome);
	}

	@Override
	public int hashCode() {
		return nome.hashCode();
	}

	/**
	 * Rimuove il partito indicato da questa coalizione, se c'era.
	 *
	 * @param partito il partito da rimuovere
	 * @return true se e solo se la coalizione è diventata vuota
	 */

	public boolean rimuovi(Partito partito) {
		partiti.remove(partito);

		return partiti.isEmpty();
	}

	@Override
	public Iterator<Partito> iterator() {
		// deleghiamo all'insieme, che sa come iterare su se stesso
		return partiti.iterator();
	}

	public String getNome() {
		return nome;
	}
}