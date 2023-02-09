package it.univr.doodle;

public class Main {
	public static void main(String[] args) {
		Slot s1 = new Slot(2017, 2, 4, Slot.Moment.MORNING);
		Slot s2 = new Slot(2017, 2, 4, Slot.Moment.AFTERNOON);
		Slot s3 = new Slot(2017, 2, 5, Slot.Moment.AFTERNOON);
		Slot s4 = new Slot(2017, 2, 5, Slot.Moment.EVENING);
		Slot s5 = new Slot(2017, 2, 5, Slot.Moment.AFTERNOON); // come s3

		Doodle doodle1 = new Doodle();
		Person ceo = new CEO("Fausto");
		Person cto = new CTO("Giovanni");
		Person secretary = new Secretary("Alessandro");
		Person programmer = new Programmer("Alessandra");
		doodle1.available(ceo, s2, s4);
		doodle1.available(cto, s1, s3, s4, s5);
		doodle1.available(secretary, s1, s3, s5);
		doodle1.available(programmer, s3);
		System.out.println("doodle1:\n" + doodle1);

		WeightedDoodle doodle2 = new WeightedDoodle();
		doodle2.available(ceo, s2, s4);
		doodle2.available(cto, s1, s3, s4, s5);
		doodle2.available(secretary, s1, s3, s5);
		doodle2.available(programmer, s3);
		System.out.println("doodle2:\n" + doodle2);
	}
}
