package it.univr.components;

public class IntCampoInserimento extends AbstractCampoInserimento {
	public IntCampoInserimento(String label, int charCount) {
		super(label, charCount);
	}

	public int getValue() {
		return Integer.parseInt(getTextField().getText());
	}
}
