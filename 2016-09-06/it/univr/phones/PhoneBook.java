package it.univr.phones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneBook extends View {
	private final List<Entry> entries = new ArrayList<>();

	public static class Entry {
		public final String name;
		public final String surname;
		public final int phone;
		public final boolean sex;
		public final static boolean MALE = false;
		public final static boolean FEMALE = true;

		private Entry(String name, String surname, int phone, boolean sex) {
			this.name = name;
			this.surname = surname;
			this.phone = phone;
			this.sex = sex;
		}

		@Override
		public String toString() {
			return name + " " + surname + ": " + phone + (sex == MALE ? " [male]" : " [female]");
		}
	}

	public PhoneBook() {
	}

	public void add(String name, String surname, int phone, boolean sex) {
		for (Entry entry: entries)
			if (entry.name.equals(name) && entry.surname.equals(surname)) {
				entries.remove(entry);
				break;
			}

		entries.add(new Entry(name, surname, phone, sex));
	}

	public void remove(String name, String surname) {
		for (Entry entry: entries)
			if (entry.name.equals(name) && entry.surname.equals(surname)) {
				entries.remove(entry);
				return;
			}		

		throw new UnknownEntryException();
	}

	@Override
	public Iterator<Entry> iterator() {
		return entries.iterator();
	}
}
