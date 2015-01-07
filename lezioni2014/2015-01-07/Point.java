
public class Point {
	public final int x;
	public final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof Point &&
			((Point) other).x == x &&
			((Point) other).y == y;
	}

	@Override
	public int hashCode() {
		return y ^ x;
	}
}
