package it.univr.phones;

import it.univr.phones.PhoneBook.Entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SortedView extends View {
	private final View parent;
	private final Comparator<Entry> comparator;

	public SortedView(View parent, Comparator<Entry> comparator) {
		this.parent = parent;
		this.comparator = comparator;
	}

	@Override
	public Iterator<Entry> iterator() {
		return new SortedViewIterator();
	}

	private class SortedViewIterator implements Iterator<Entry> {
		private final Entry[] sortedEntries;
		private int pos;

		private SortedViewIterator() {
			List<Entry> entries = new ArrayList<>();
			for (Entry entry: parent)
				entries.add(entry);

			sortedEntries = entries.toArray(new Entry[entries.size()]);
			Arrays.sort(sortedEntries, comparator);
		}

		@Override
		public boolean hasNext() {
			return pos < sortedEntries.length;
		}

		@Override
		public Entry next() {
			return sortedEntries[pos++];
		}

		@Override
		public void remove() {
		}
	}
}