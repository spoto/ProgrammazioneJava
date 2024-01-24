package it.univr.instructions;

import java.util.List;

public class POP implements Instruction {

	public POP() {
	}

	@Override
	public void execute(List<Integer> stack) throws IllegalProgramException {
		int size = stack.size();
		if (size == 0)
			throw new IllegalProgramException("Pop da uno stack vuoto");

		stack.remove(size - 1);
	}

	@Override
	public String toString() {
		return "pop";
	}
}