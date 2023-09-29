package it.univr.instructions;

import java.util.List;

public class ADD implements Instruction {

	public ADD() {
	}

	@Override
	public void execute(List<Integer> stack) throws IllegalProgramException {
		int size = stack.size();
		if (size < 2)
			throw new IllegalProgramException("Operandi insufficienti per un'operazione binaria");

		int top = stack.remove(size - 1);
		int underTop = stack.remove(size - 2);
		stack.add(top + underTop);
	}

	@Override
	public String toString() {
		return "add";
	}
}