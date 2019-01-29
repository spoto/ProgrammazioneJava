package it.univr.rent;

public class Motorbike extends AbstractModel {

	public Motorbike(String name, int pricePerDay) {
		super(name, pricePerDay);
	}

	@Override
	public boolean canBeDrivenWith(License license) {
		return true;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof Motorbike &&
			getName().equals(((Motorbike) other).getName()) &&
			pricePerDay() == ((Motorbike) other).pricePerDay();
	}
}