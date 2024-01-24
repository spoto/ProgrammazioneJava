package it.univr.tokenizer;

public class CharacterTokenization extends StringTokenization {

	public CharacterTokenization(String s, char c) {
		super(s, String.valueOf(c));
	}
}