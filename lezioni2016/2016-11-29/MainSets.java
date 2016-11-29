import java.util.HashSet;
import java.util.LinkedList;

public class MainSets {

	public static void main(String[] args) {
		HashSet<String> s1 = new HashSet<>();
		s1.add("ciao");
		s1.add("hello");
		s1.add("buongiorno");
		String s = new String("hello");
		s1.add(s);
		
		LinkedList<String> ll = new LinkedList<>(s1);

		System.out.println(s1);

		for (String x: s1)
			System.out.println(x);
	}

}
