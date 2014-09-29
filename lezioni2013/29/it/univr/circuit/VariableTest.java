package it.univr.circuit;

import static org.junit.Assert.*;
import org.junit.Test;

public class VariableTest {

	@Test
	public void testEquals() {
		assertEquals(new Variable("v"), new Variable("v"));
	}

	@Test
	public void testNotEquals() {
		assertFalse(new Variable("v").equals(new Variable("a")));
	}

	@Test
	public void testFreeVariables() {
		Variable[] fv = new Variable("v").freeVariables();
		assertArrayEquals(new Variable[] { new Variable("v") }, fv);
	}

	@Test
	public void testIsTrueIn() {
		Assignment assignment = new Assignment("v", "w");
		Variable v = new Variable("v");
		assertTrue(v.isTrueIn(assignment));
		Variable w = new Variable("w");
		assertTrue(w.isTrueIn(assignment));
		Variable pippo = new Variable("pippo");
		assertFalse(pippo.isTrueIn(assignment));
	}
}