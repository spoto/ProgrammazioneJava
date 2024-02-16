package it.univr.prefix;

public class Main {

	public static void main(String[] args) {
		PrefixMap<Integer> pm = new PrefixMap<Integer>();
		pm.put("hello", 13);
		pm.put("computer", 17);
		pm.put("computee", 19);
		pm.put("courage", 41);
		pm.put("alliance", 17);
		pm.put("help", 78);
		pm.put("computed", 91);
		pm.put("courage", 42);
		pm.put("", 11);
		pm.put("alliances", null);
		System.out.println("computer -> " + pm.get("computer"));
		System.out.println("computed -> " + pm.get("computed"));
		System.out.println("computee -> " + pm.get("computee"));
		System.out.println("hello -> " + pm.get("hello"));
		System.out.println("help -> " + pm.get("help"));
		System.out.println("hel -> " + pm.get("hel")); // null perché non c'è
		System.out.println("helpo -> " + pm.get("helpo")); // null perché non c'è
		System.out.println(" -> " + pm.get(""));
		System.out.println("alliance -> " + pm.get("alliance"));
		System.out.println("alliances -> " + pm.get("alliances")); // null perché non c'è
		System.out.println("courage -> " + pm.get("courage"));
		System.out.println("computers -> " + pm.get("computers")); // null perché non c'è
		System.out.println(pm);
		pm.put(null, 113);
	}
}