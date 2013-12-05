package it.univr.circuit;

import java.util.HashSet;
import java.util.Set;

public class Variable extends Circuit {

	private final String name;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}