package it.univr.quindici;

public abstract class Tessera implements Comparable<Tessera> {

	@Override
	public abstract boolean equals(Object other);

	@Override
	public abstract int hashCode();

	@Override
	public abstract String toString();
}