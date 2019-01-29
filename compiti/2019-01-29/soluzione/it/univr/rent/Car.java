package it.univr.rent;

public class Car extends AbstractModel {

	public Car(String name, int pricePerDay) {
		super(name, pricePerDay);
	}

	@Override
	public boolean canBeDrivenWith(License license) {
		return license != License.A;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof Car &&
			getName().equals(((Car) other).getName()) &&
			pricePerDay() == ((Car) other).pricePerDay();
	}
}