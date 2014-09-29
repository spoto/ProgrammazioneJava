package it.univr.circuit;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssignmentTest {

	@Test
	public void testValueOf() {
		Assignment a = new Assignment("a", "b", "c");
		assertTrue(a.valueOf(new Variable("a")));
		assertTrue(a.valueOf(new Variable("b")));
		assertTrue(a.valueOf(new Variable("b")));
		assertTrue(a.valueOf(new Variable("c")));
		assertFalse(a.valueOf(new Variable("d")));
		assertFalse(a.valueOf(new Variable("pippo")));
	}
}