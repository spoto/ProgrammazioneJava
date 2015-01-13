import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(13);
		al.add(17);
		al.add(23);
		
		List l = new List(al);
		System.out.println(l.length());
	}
}
