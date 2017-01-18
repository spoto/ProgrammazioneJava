import java.util.Iterator;
import java.util.TreeSet;

public class CartelloneModificabile extends Cartellone {
	private final TreeSet<Train> trains = new TreeSet<>();

	public CartelloneModificabile() {}

	public void add(Train train) {
		trains.add(train);
	}

	public void add(Iterable<Train> trains) {
		for (Train train: trains)
			this.trains.add(train);
	}
	
	public void add(Train... trains) {
		for (Train train: trains)
			this.trains.add(train);
	}

	@Override
	public Iterator<Train> iterator() {
		return trains.iterator();
	}
}