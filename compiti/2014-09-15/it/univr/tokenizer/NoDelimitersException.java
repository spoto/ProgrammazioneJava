package it.univr.tokenizer;

public class NoDelimitersException extends RuntimeException {
	public NoDelimitersException() {
		super("no delimiters specified");
	}
}