package it.univr.numeri;

public interface Numero extends Comparable<Numero> {
	public int getValue();
	public void aggiungi(Numero n);
	public void sottrai(Numero n);
}
