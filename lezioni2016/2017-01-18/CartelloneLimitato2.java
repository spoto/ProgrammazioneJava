import java.util.ArrayList;
import java.util.Iterator;

public class CartelloneLimitato2 extends Cartellone {
	private final Cartellone original;
	private final int max;

	public CartelloneLimitato2(Cartellone original, int max) {
		this.original = original;
		this.max = max;
	}

	@Override
	public Iterator<Train> iterator() {
		// questa implementazione restituisce un iteratore sugli
		// elementi al momento della chiamata di iterator()
		ArrayList<Train> firstMax = new ArrayList<>();
		int counter = 0;
		for (Train train: original)
			if (counter++ < max)
				firstMax.add(train);

		return firstMax.iterator();
	}
}