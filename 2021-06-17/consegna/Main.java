package it.univr.books;

import static it.univr.books.Book.LANGUAGE.*;

/*
 Se tutto e' corretto, l'esecuzione di questa classe deve stampare:

A Midsummer Night's Dream
Bonjour tristesse
La Divina Commedia
A la recherche du temps perdu
The great Gatsby
I Promessi Sposi

A Midsummer Night's Dream
The great Gatsby
A la recherche du temps perdu
Bonjour tristesse
I Promessi Sposi
La Divina Commedia

Exception in thread "main" java.lang.IllegalArgumentException: Book too high!
 */
public class Main {
	private final static Book[] books = {
		new Book("I Promessi Sposi", 1000, 30, ITALIAN),
		new Book("The great Gatsby", 250, 20, ENGLISH),
		new Book("Bonjour tristesse", 182, 18, FRENCH),
		new Book("La Divina Commedia", 830, 19, ITALIAN),
		new Book("A Midsummer Night's Dream", 189, 15, ENGLISH),
		new Book("A la recherche du temps perdu", 540, 20, FRENCH),
	};

	public static void main(String[] args) {
		fillLibrary(new LibraryBySize(40));
		fillLibrary(new LibraryEnglishFirst(30));
		fillLibrary(new LibraryBySize(25)); // troppo stretta per I Promessi Sposi
	}

	private static void fillLibrary(Library library) {
		for (Book book: books)
			library.add(book);

		System.out.println(library);
	}
}