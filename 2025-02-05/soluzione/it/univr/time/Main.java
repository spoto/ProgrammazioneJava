package it.univr.time;

public class Main {

	public static void main(String[] args) {
		Time t1 = new ItalianTime(12 * 3600 + 22 * 60 + 59); // le 12:22:59
		Time t2 = new AmericanTime(12 * 3600 + 22 * 60 + 59); // le 12:22:59
		Time t3 = new ItalianTime(23 * 3600 + 59 * 60 + 59); // le 23:59:59
		Time t4 = new AmericanTime(23 * 3600 + 59 * 60 + 59); // le 23:59:59
		System.out.println("t1 = " + t1);
		System.out.println("t2 = " + t2);
		System.out.println("t3 = " + t3);
		System.out.println("t4 = " + t4);
		System.out.println("t3.next() = " + t3.next());
		System.out.println("t4.next() = " + t4.next());

		System.out.println("10 secondi da t3 in poi:");
		for (Time t: t3.interval(10))
			System.out.println(t);

		System.out.println("10 secondi da t4 in poi:");
		for (Time t: t4.interval(10))
			System.out.println(t);
	}
}
