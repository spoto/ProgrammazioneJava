
public abstract class Felino {
	public abstract boolean èDomestico();

	public abstract int costo();

	public abstract String toString();

	public final boolean possoComprarloCon(int euro) {
		return èDomestico() && costo() <= euro;
	}
}
