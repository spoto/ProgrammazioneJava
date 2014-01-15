package it.univr.components;

public class TextCampoInserimento extends AbstractCampoInserimento {
	public TextCampoInserimento(String label, int charCount) {
		super(label, charCount);
	}

	public String getText() {
		return getTextField().getText();
	}
}
