package it.univr.airbust;
import it.univr.bookings.Aircraft;
import it.univr.bookings.Date;
import it.univr.bookings.Fleet;

public class AirBustFleet implements Fleet {
	private final static Aircraft a320 = new Aircraft("A320", 200);
	private final static Aircraft a330 = new Aircraft("A330", 277);
	private final static Aircraft a380 = new Aircraft("A380", 388);

	@Override
	public Aircraft getAircraftFor(Date when) {
		if (when.isXmas() || when.isThanksgiving() || when.isNewYearsEve())
			return a380;
		else if (when.isColumbusDay())
			return a330;
		else
			return a320;
	}
}