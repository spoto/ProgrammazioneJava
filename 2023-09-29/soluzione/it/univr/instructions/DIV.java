package it.univr.instructions;

import java.util.List;

public class DIV implements Instruction {

	public DIV() {
	}

	@Override
	public void execute(List<Integer> stack) throws IllegalProgramException {
		int size = stack.size();
		if (size < 2)
			throw new IllegalProgramException("Operandi insufficienti per un'operazione binaria");

		int top = stack.remove(size - 1);
		int underTop = stack.remove(size - 2);
		if (top == 0)
			throw new IllegalProgramException("Divisione per zero");

		stack.add(underTop / top);
	}

	@Override
	public String toString() {
		return "div";
	}
}
