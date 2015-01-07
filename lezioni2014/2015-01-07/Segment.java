
public class Segment {
	private Point p1;
	private Point p2;
	public Segment(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;

	}

	// metodo di modifica: non chiamarlo se
	// usate gli HashSet!!!!!
	public void sposta(int dx, int dy) {
		p1 = new Point(p1.x + dx, p1.y + dy);
		p2 = new Point(p2.x + dx, p2.y + dy);
	}

	public String toString() {
		return p1 + "--" + p2;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Segment) {
			Segment other = (Segment) obj;
			return (p1.equals(other.p1) && p2.equals(other.p2))
					
					||
					
					(p1.equals(other.p2) && p2.equals(other.p1));
		}
		else
			return false;
	}

	@Override
	public int hashCode() {
		return p1.hashCode() ^ p2.hashCode();
	}
}

