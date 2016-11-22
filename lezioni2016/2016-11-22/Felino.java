
public class Felino {
	public boolean èDomestico() {
		return true;
	}

	public int costo() {
		return 0;
	}

	public String toString() {
		return "";
	}

	public final boolean possoComprarloCon(int euro) {
		return èDomestico() && costo() <= euro;
	}
}
