package com.hotmoka.examples.concurrency;
/**
 * A fork. This is a modern and very handy tool for bringing food
 * inside the mouth of humans. Forks have a unique identifier
 * that is used to compare them.
 * 
 * @author <A HREF="mailto:fausto.spoto@univr.it">Fausto Spoto</A>
 */

public class Fork implements Comparable<Fork> {

	/**
	 * The identifier that will be assigned to the next fork
	 * that will be created.
	 */

	private static int nextId;

	/**
	 * The unique identifier of this fork.
	 */

	private final int id = nextId++;

	@Override
	public int compareTo(Fork other) {
		return id - other.id;
	}

	@Override
	public String toString() {
		return "fork " + id;
	}
}