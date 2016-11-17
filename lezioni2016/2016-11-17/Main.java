
public class Main {
	public static void main(String[] args) {
		List l = new List(-3, null);
		l = new List(23, l);
		l = new List(17, l);
		l = new List(13, l);
		
		System.out.println(l.toString());
		System.out.println("lunghezza: " + l.length());
	}
}
