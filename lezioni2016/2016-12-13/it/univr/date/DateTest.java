package it.univr.date;

import org.junit.Assert;
import org.junit.Test;

public class DateTest {

	@Test
	public void testToString() {
		Date d = new Date(13, 1, 1973);
		String s = d.toString();

		// verifico che s sia equals a "13 gennaio 1973"
		Assert.assertEquals(s, "13 gennaio 1973");
	}

	@Test
	public void testPrecede() {
		Date d1 = new Date(13, 1, 1973);
		Date d2 = new Date(12, 1, 1973);
		
		Assert.assertTrue(d2.precede(d1));
	}

	@Test
	public void testPassatiDallInizioDellAnno() {
		Date d = new Date(25, 10, 2016);
		Assert.assertEquals(d.passatiDallInizioDellAnno(), 299);
	}
}
