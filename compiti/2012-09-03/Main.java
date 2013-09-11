public class Main {

	public static void main(String[] args) {
		Set s1 = new ArraySet("ciao", "amico", "come", "va?");
		Set s2 = new ModifiableArraySet("oggi", "va?", 12, 113);

		System.out.println("1: " + s1.equals(s2));
		System.out.println("2: " + s1.intersects(s2));

		ModifiableSet s3 = new ModifiableArraySet("amico", "va?", "ciao", "va?");
		s3.add("come");
		s3.add(new String("ciao"));

		System.out.println("3: " + s1.equals(s3));
		System.out.println("4: " + s1.intersects(s3));
	}

}