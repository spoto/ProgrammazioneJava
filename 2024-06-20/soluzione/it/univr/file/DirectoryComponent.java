package it.univr.file;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectoryComponent extends AbstractComponent {
	private final Component[] children;

	/**
	 * Costruisce una componente di tipo directory con il nome indicato
	 * e le sottocomponenti (figli) indicate.
	 */
	public DirectoryComponent(String name, Component... children) {
		super(name);

		this.children = children;
		// ordiniamo i figli per nome, cosi' verranno riportati ordinati nel toString()
		Arrays.sort(children, (child1, child2) -> child1.getName().compareTo(child2.getName()));
	}

	@Override
	public String toString(String nesting) {
		String result = nesting + getName() + "/";

		for (Component child: children)
			result += "\n" + child.toString(nesting + "  ");

		return result;
	}

	@Override
	public int size() {
		int result = 100;
		for (Component child: children)
			result += child.size();

		return result;
	}

	@Override
	public List<FileComponent> getFiles() {
		List<FileComponent> result = new ArrayList<>();
		for (Component child: children)
			result.addAll(child.getFiles());

		return result;
	}

	@Override
	public String find(String name) throws FileNotFoundException {
		for (Component child: children) {
			try {
				return getName() + "/" + child.find(name);
			}
			catch (FileNotFoundException e) {
				// ignoriamo e continuiamo a cercare con gli altri figli
			}
		}

		// non lo abbiamo trovato a partire da nessuno dei nostri figli
		throw new FileNotFoundException(name);
	}
}