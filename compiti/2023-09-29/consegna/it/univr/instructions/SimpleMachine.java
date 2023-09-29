package it.univr.instructions;

import java.util.ArrayList;
import java.util.List;

public class SimpleMachine implements Machine {
	
	// inizialmente lo stack e' vuoto
	private final List<Integer> stack = new ArrayList<>();

	private final int result;

	/**
	 * Esegue il programma indicato.
	 * 
	 * @param program il programma da eseguire
	 * @throws IllegalProgramException se l'esecuzione del programma fallisce per qualche motivo
	 */
	public SimpleMachine(List<Instruction> program) throws IllegalProgramException {
		result = execute(program);
	}

	@Override
	public final int getResult() {
		return result;
	}

	/**
	 * Esegue le istruzioni del programma, dall'inizio alla fine, partendo da uno stack
	 * vuoto. Dopo avere eseguite tutte le istruzioni, restituisce l'elemento in cima allo stack
	 * risultante alla fine.
	 * 
	 * @param program il programma da eseguire
	 * @return l'elemento che c'e' in cima allo stack alla fine dell'esecuzione del programma
	 * @throws IllegalProgramException se l'esecuzione del programma va in errore oppure se
	 *                                 alla fine dell'esecuzione lo stack e' vuoto (e quindi
	 *                                 non c'e' nessun elemento in cima da potere ritornare)
	 */
	private int execute(List<Instruction> program) throws IllegalProgramException {
		return 0; // TODO
	}

	/**
	 * Esegue un'istruzione sullo stack indicato.
	 * 
	 * @throws IllegalProgramException se l'esecuzione dell'istruzione fallisce
	 */
	protected void execute(Instruction ins, List<Integer> stack) throws IllegalProgramException {
		ins.execute(stack);
	}
}