package it.univr.rent;

public class Bus extends AbstractModel {

	public Bus(String name, int pricePerDay) {
		super(name, pricePerDay);
	}

	@Override
	public boolean canBeDrivenWith(License license) {
		return license == License.D;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof Bus &&
			getName().equals(((Bus) other).getName()) &&
			pricePerDay() == ((Bus) other).pricePerDay();
	}
}