package it.univr.instructions;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Instruction> program = new ArrayList<>();
		program.add(new PUSH(5));
		program.add(new PUSH(13));
		program.add(new PUSH(17));
		program.add(new ADD());
		
		execute(program);

		List<Instruction> program2 = new ArrayList<>();
		program2.add(new REPEAT(5, new PUSH(13)));
		program2.add(new REPEAT(4, new ADD()));
		execute(program2);

		List<Instruction> program3 = new ArrayList<>();
		program3.add(new REPEAT(5, new PUSH(13)));
		program3.add(new REPEAT(5, new ADD()));
		execute(program3);
	}

	private static void execute(List<Instruction> program) {
		System.out.println(" * * * Eseguo " + program + " * * *\n");
		try {
			System.out.println("Simple machine:");
			int result = new SimpleMachine(program).getResult();
			System.out.println("result = " + result + "\n");
		}
		catch (IllegalProgramException e) {
			System.out.println("Errore: " + e.getMessage() + "\n");
		}

		try {
			System.out.println("Printing machine:");
			int result = new PrintingMachine(program).getResult();
			System.out.println("result = " + result + "\n");
		}
		catch (IllegalProgramException e) {
			System.out.println("Errore: " + e.getMessage() + "\n");
		}
	}
}