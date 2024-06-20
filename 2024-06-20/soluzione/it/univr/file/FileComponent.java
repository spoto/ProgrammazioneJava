package it.univr.file;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FileComponent extends AbstractComponent {
	private final int size;

	/**
	 * Costruisce una componente di tipo file con il nome indicato
	 * e la dimensione in byte indicata.
	 */
	public FileComponent(String name, int size) {
		super(name);

		this.size = size;
	}

	@Override
	public String toString(String nesting) {
		return nesting + getName();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<FileComponent> getFiles() {
		List<FileComponent> result = new ArrayList<>();
		result.add(this);
		return result;
	}

	@Override
	public String find(String name) throws FileNotFoundException {
		if (name.equals(getName()))
			return name;
		else
			throw new FileNotFoundException(name);
	}
}