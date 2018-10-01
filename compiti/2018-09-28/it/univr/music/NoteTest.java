package it.univr.music;

import static org.junit.Assert.*;
import org.junit.Test;

public class NoteTest {

	@Test
	public void testToString() {
		assertEquals(ItalianNote.DO.toString(), "do");
	}

	@Test
	public void testEquals() {
		assertEquals(ItalianNote.RE_DIESIS, EnglishNote.D_SHARP);
	}

	@Test
	public void testHashCode() {
		assertTrue(ItalianNote.RE_DIESIS.hashCode() == EnglishNote.D_SHARP.hashCode());
	}

	@Test
	public void testHashCodeNonTrivial() {
		assertTrue(ItalianNote.RE_DIESIS.hashCode() != EnglishNote.E.hashCode());
	}

	@Test
	public void testCompareTo() {
		assertTrue(ItalianNote.DO.compareTo(EnglishNote.D) < 0);
	}
}