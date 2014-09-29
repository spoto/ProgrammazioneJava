package it.univr.circuit;

import static org.junit.Assert.*;
import org.junit.Test;

public class OrTest {

	@Test
	public void testEquals() {
		assertEquals(new Or(new Variable("v"), new Variable("v")), new Variable("v"));
	}

	@Test
	public void testTautology() {
		assertEquals(new Or(new Variable("v"), new Not(new Variable("v"))), new Or(new Variable("w"), new Not(new Variable("w"))));
	}

	@Test
	public void testNotEquals() {
		assertFalse(new Or(new Variable("v"), new Variable("w")).equals(new Variable("w")));
	}

	@Test
	public void testFreeVariables() {
		Variable[] fv = new Or(new Variable("v"), new Or(new Variable("v"), new Variable("w"))).freeVariables();
		assertSame(fv.length, 2);
		assertFalse(fv[0].equals(fv[1]));
		assertTrue(fv[0].equals(new Variable("v")) || fv[0].equals(new Variable("w")));
		assertTrue(fv[1].equals(new Variable("v")) || fv[1].equals(new Variable("w")));
	}

	@Test
	public void testIsTrueIn() {
		Assignment assignment = new Assignment("v");
		Circuit circuit = new Or(new Variable("v"), new Or(new Variable("v"), new Variable("w")));
		assertTrue(circuit.isTrueIn(assignment));
	}

	@Test
	public void testIsNotTrueIn() {
		Assignment assignment = new Assignment("w");
		Circuit circuit = new Or(new Variable("v"), new Or(new Variable("a"), new Variable("b")));
		assertFalse(circuit.isTrueIn(assignment));
	}
}