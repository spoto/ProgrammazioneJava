package it.univr.rent;

public class Truck extends AbstractModel {

	public Truck(String name, int pricePerDay) {
		super(name, pricePerDay);
	}

	@Override
	public boolean canBeDrivenWith(License license) {
		return license == License.C;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof Truck &&
			getName().equals(((Truck) other).getName()) &&
			pricePerDay() == ((Truck) other).pricePerDay();
	}
}