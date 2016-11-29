import java.util.LinkedList;
import java.util.List;

public class MainLists {

	public static void main(String[] args) {
		List<String> l1 = new LinkedList<>();
		l1.add("ciao");
		l1.add("hello");
		l1.add(1, "buongiorno");

		String s = new String("ciao");
		if (l1.contains(s))
			System.out.println("sì");
		else
			System.out.println("no");

		System.out.println(l1);
		System.out.println(l1.get(2));
		System.out.println(l1.size());

		for (int pos = 0; pos < l1.size(); pos++)
			System.out.println(l1.get(pos));

		for (String x: l1)
			System.out.println(x);
	}

}
