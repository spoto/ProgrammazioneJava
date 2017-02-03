package it.univr.doodle;

public class Main {
	public static void main(String[] args) {
		Slot s1 = new Slot(2017, 2, 4, Slot.Moment.MORNING);
		Slot s2 = new Slot(2017, 2, 4, Slot.Moment.AFTERNOON);
		Slot s3 = new Slot(2017, 2, 5, Slot.Moment.AFTERNOON);
		Slot s4 = new Slot(2017, 2, 5, Slot.Moment.EVENING);
		Slot s5 = new Slot(2017, 2, 4, Slot.Moment.AFTERNOON); // like s2

		Doodle doodle1 = new Doodle();
		doodle1.available("Fausto", s2, s4);
		doodle1.available("Giovanni", s1, s3, s4, s5);
		doodle1.available("Maria", s1, s2, s3, s5);
		doodle1.available("Alessandra", s3);
		System.out.println("doodle1:\n" + doodle1);

		WeightedDoodle doodle2 = new WeightedDoodle();
		// la presenza di Fausto è abbastanza importante (0.8)
		doodle2.available("Fausto", 0.8, s2, s4);
		// la presenza di Giovanni è mediamente importante (0.5) 
		doodle2.available("Giovanni", 0.5, s1, s3, s4, s5);
		// la presenza di Maria è quasi irrilevante (0.2)
		doodle2.available("Maria", 0.2, s1, s2, s3, s5);
		// la presenza di Alessandra è molto importante (1.0)
		doodle2.available("Alessandra", 1.0, s3);
		System.out.println("doodle2:\n" + doodle2);
	}
}
