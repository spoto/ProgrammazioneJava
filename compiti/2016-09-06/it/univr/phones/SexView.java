package it.univr.phones;

import it.univr.phones.PhoneBook.Entry;

import java.util.Iterator;

public class SexView extends View {
	private final View parent;
	private final boolean sex;

	public SexView(View parent, boolean sex) {
		this.parent = parent;
		this.sex = sex;
	}

	@Override
	public Iterator<Entry> iterator() {
		return new SexViewIterator();
	}

	private class SexViewIterator implements Iterator<Entry> {
		private final Iterator<Entry> iteratorOfParent;
		private Entry next;

		private SexViewIterator() {
			iteratorOfParent = parent.iterator();
			lookForSex();
		}

		private void lookForSex() {
			next = null;

			while (iteratorOfParent.hasNext()) {
				Entry cursor = iteratorOfParent.next();
				if (cursor.sex == sex) {
					next = cursor;
					return;
				}
			}
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public Entry next() {
			Entry result = next;
			lookForSex();

			return result;
		}

		@Override
		public void remove() {
		}
	}
}