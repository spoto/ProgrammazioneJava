import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		Point p1 = new Point(3, 5);
		Point p2 = new Point(5, 3);
		Point p3 = new Point(4, 7);
		Point p4 = new Point(-3, 6);
		Point p5 = new Point(5, 3);
		
		HashSet<Point> s = new HashSet<>();
		s.add(p1);
		s.add(p2);
		s.add(p3);
		s.add(p4);
		s.add(p5);
		
		System.out.println(s.size());
		System.out.println(s);

		Segment seg1 = new Segment(p1, p2);
		Segment seg2 = new Segment(p1, p5);
		Segment seg3 = new Segment(p3, p4);

		HashSet<Segment> ss = new HashSet<>();
		ss.add(seg1);
		ss.add(seg2);
		ss.add(seg3);

		System.out.println(ss.size());
		System.out.println(ss);

		System.out.println("seg3 prima dello spostamento " + seg3);
		seg3.sposta(3, 7);
		System.out.println("seg3 dopo lo spostamento " + seg3);

		System.out.println(ss.contains(seg3));
		System.out.println(ss);
	}
}
