import java.util.HashMap;
import java.util.Map;


public class Main {
	public static void main(String[] args) {
		Map<Person, Integer> bank = new HashMap<>();
		Person fs = new Person("fausto", "spoto", 10, 10, 1990);
		Person rb = new Person("roberto", "giacobazzi", 8, 9, 1940);
		bank.put(fs, 1000);
		bank.put(rb, 1500);
		
		bank.remove(fs);

		if (bank.containsKey(fs))
			System.out.println(fs + " ha un cc");
		else
			System.out.println(fs + " non ha un cc");
		
		int soldi = bank.get(rb);
		System.out.println(rb + " ha " + soldi + " euro su cc");
	}
}
