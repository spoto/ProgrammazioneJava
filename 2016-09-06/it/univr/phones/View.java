package it.univr.phones;

import it.univr.phones.PhoneBook.Entry;

public abstract class View implements Iterable<Entry> {

	protected View() {
	}

	@Override
	public final String toString() {
		String result = "";
		for (Entry entry: this)
			result += entry.toString() + "\n";

		return result;
	}
}