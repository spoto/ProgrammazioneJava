package it.univr.quindici;

import java.util.Random;
import java.util.function.Supplier;

// Una fattoria di tessere e' un oggetto capace di generare una nuova
// tessera ogni volta che si chiama il suo metodo get() (definito in Supplier).
// Al suo interno mettiamo un oggetto Random che può essere usato nelle sottoclassi
// per fare scelte casuali

// non modificate
public abstract class FattoriaDiTessere<T extends Comparable<T>> implements Supplier<Tessera<T>> {
	protected final static Random random = new Random();
}