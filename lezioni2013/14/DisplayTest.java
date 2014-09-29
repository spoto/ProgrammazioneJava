import static org.junit.Assert.*;

import org.junit.Test;


public class DisplayTest {

	@Test
	public void test1() {
		Display d = new Display(9);
		d.next();

		assertTrue(d.getDigit() == 0);
	}

	@Test
	public void test2() {
		Display d = new Display(8);

		assertTrue(d.toString().equals(
			"***\n* *\n***\n* *\n***\n"));
	}

	@Test
	public void test3() {
		Display d1 = new Display(8);
		d1.next();
		Display d2 = new Display(9);

		assertTrue(d1.equals(d2));
	}
}