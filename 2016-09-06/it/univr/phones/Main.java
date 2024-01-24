package it.univr.phones;

import java.util.Comparator;

import it.univr.phones.PhoneBook.Entry;
import static it.univr.phones.PhoneBook.Entry.*;

public class Main {
	public static void main(String[] args) {
		PhoneBook book = new PhoneBook();
		book.add("Primo", "Levi", 7569222, MALE);
		book.add("Fausto", "Spoto", 1234567, MALE);
		book.add("Giorgio", "Levi", 1563423, MALE);
		book.add("Catherine", "Bach", 367745, FEMALE);
		book.add("Pietro", "Ferrara", 7865634, MALE);
		book.add("Alberto", "Lovato", 8746728, MALE);
		book.add("Thomas", "Scudiero", 453678, MALE);
		book.add("Pietro", "Ferrara", 333334, MALE); // sostituisce
		book.add("Cybill", "Shepherd", 987567546, FEMALE);
		book.add("Audrey", "Hepburn", 32444, FEMALE);
		book.remove("Fausto", "Spoto");

		View view = book;
		System.out.println("DIRECT VIEW");
		System.out.println(view);

		view = new SexView(view, MALE);
		System.out.println("MALE ONLY VIEW");
		System.out.println(view);

		Comparator<Entry> comparator = new Comparator<Entry>() {

			@Override
			public int compare(Entry address1, Entry address2) {
				int diff = address1.surname.compareTo(address2.surname);
				if (diff != 0)
					return diff;
				else
					return address1.name.compareTo(address2.name);
			}
		};

		view = new SortedView(view, comparator);
		System.out.println("SORTED MALE ONLY VIEW");
		System.out.println(view);
	}
}