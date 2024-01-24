package it.univr.instructions;

import java.util.List;

public class REPEAT implements Instruction {
	private final int howManyTimes;
	private final Instruction ins;

	public REPEAT(int howManyTimes, Instruction ins) {
		if (howManyTimes < 0)
			throw new IllegalArgumentException();

		this.howManyTimes = howManyTimes;
		this.ins = ins;
	}

	@Override
	public void execute(List<Integer> stack) throws IllegalProgramException {
		for (int count = 0; count < howManyTimes; count++)
			ins.execute(stack);
	}

	@Override
	public String toString() {
		return "repeat(" + howManyTimes + ", " + ins + ")";
	}
}