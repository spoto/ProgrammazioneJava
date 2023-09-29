package it.univr.instructions;

import java.util.List;

public interface Instruction {

	/**
	 * Esegue questa istruzione con lo stack indicato.
	 * Tipicamente, l'esecuzione modifichera' lo stack.
	 * 
	 * @param stack lo stack su cui si esegue l'istruzione
	 * @throws IllegalProgramException se l'esecuzione dell'istruzione fallisce
	 */
	void execute(List<Integer> stack) throws IllegalProgramException;

	/**
	 * Restituisce una descrizione stringa dell'istruzione.
	 */
	String toString();
}