package it.univr.instructions;

import java.util.List;

public class PUSH implements Instruction {
	private final int constant;

	public PUSH(int constant) {
		this.constant = constant;
	}

	@Override
	public void execute(List<Integer> stack) throws IllegalProgramException {
		stack.add(constant);
	}

	@Override
	public String toString() {
		return "push(" + constant + ")";
	}
}