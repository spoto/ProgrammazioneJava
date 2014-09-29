package it.univr.circuit;

import static org.junit.Assert.*;
import org.junit.Test;

public class NotTest {

	@Test
	public void testEquals() {
		assertEquals(new Variable("v"), new Not(new Not(new Variable("v"))));
	}

	@Test
	public void testNotEquals() {
		assertFalse(new Variable("v").equals(new Not(new Variable("v"))));
		assertFalse(new Variable("v").equals(new Not(new Not(new Variable("b")))));
	}

	@Test
	public void testFreeVariables() {
		Variable[] fv = new Not(new Variable("v")).freeVariables();
		assertArrayEquals(new Variable[] { new Variable("v") }, fv);
	}

	@Test
	public void testIsTrueIn() {
		Assignment assignment = new Assignment("v", "w");
		Not notV = new Not(new Variable("v"));
		assertFalse(notV.isTrueIn(assignment));
		Not notW = new Not(new Variable("w"));
		assertFalse(notW.isTrueIn(assignment));
		Not notPippo = new Not(new Variable("pippo"));
		assertTrue(notPippo.isTrueIn(assignment));
	}
}