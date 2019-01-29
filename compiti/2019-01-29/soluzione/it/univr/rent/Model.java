package it.univr.rent;

public interface Model extends Comparable<Model> {
	public String getName();
	public boolean canBeDrivenWith(License license);
	public int pricePerDay();
}