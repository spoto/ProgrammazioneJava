package it.univr.elezioni;

public class CoalizioneGiàPresenteException extends IllegalArgumentException {
	public CoalizioneGiàPresenteException(Coalizione coalizione) {
		super(coalizione.getNome());
	}
}