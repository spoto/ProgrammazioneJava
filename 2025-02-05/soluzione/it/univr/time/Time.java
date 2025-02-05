package it.univr.time;

// un istante di tempo (ore, minuti, secondi)
public interface Time {

	// restituisce i secondi passati dall'inizio del giorno
	int getSecondsFromStartOfDay();

	// restituisce l'istante successivo, ciclicamente (dopo mezzanotte si ricomincia dalla mattina)
	// verrà restituito un oggetto dello stesso tipo di this
	// (ovvero ItalianTime restituiscono ItalianTime e AmericanTime restituiscono AmericanTime)
	Time next();

	// restituisce un periodo di tempo da this (incluso) a this + howManySeconds (escluso)
	// lancia IllegalArgumentException se howManySeconds è negativo
	Interval interval(int howManySeconds);
}
