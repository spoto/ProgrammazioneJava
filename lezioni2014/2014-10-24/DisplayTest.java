import org.junit.Assert;
import org.junit.Test;

public class DisplayTest {

	@Test
	public void noveIncrementatoFaZero() {
		Display d = new Display(9);
		d.next();
		Assert.assertTrue(d.getDigit() == 0);
	}

	@Test
	public void ottoToString() {
		Display d = new Display(8);
		Assert.assertEquals("***\n* *\n***\n* *\n***\n", d.toString());
	}

	@Test
	public void ottoNextEqualsNove() {
		Display d8 = new Display(8);
		d8.next();
		Display d9 = new Display(9);
		Assert.assertTrue(d8.equals(d9));
	}
}