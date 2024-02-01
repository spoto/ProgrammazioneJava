package it.univr.sudoku;

import java.util.Random;
import java.util.function.IntFunction;

// un sudoku in cui i numeri da 1 a 9 vengono rappresentati con elementi di tipo E
public class Sudoku<E> {

	// le caselle del sudoku: contengono numeri tra 1 e 9,
	// oppure 0, che indica una casella vuota;
	// la casella (0,0) è quella in alto a sinistra;
	// la casella (8,8) è quella in basso a destra
	private final int[][] matrix = new int[9][9];

	// una funzione che dato un numero tra 1 e 9 restituisce
	// l'elemento di tipo E per rappresentare quel numero
	private final IntFunction<E> generator;

	// la dimensione della stampa di un elemento di tipo E:
	// si assume che tutti gli elementi di tipo E abbiano
	// la stessa dimensione di stampa; questa informazione vi
	// risulterà utile quando dovrete stampare le caselle
	// vuote del sudoku, per capire quanti spazi dovete fare
	private final int elementSize;

	public Sudoku(int empty, IntFunction<E> generator) {
		// completare lanciando una IllegalArgumentException se empty
		// non fosse tra 0 e 61 inclusi

		this.generator = generator;

		// calcoliamo quanto e' lunga la stampa dell'elemento che rappresenta 1:
		// stiamo assumendo che la stampa di tutti gli elementi abbia la stessa lunghezza
		this.elementSize = generator.apply(1).toString().length();

		// genera un Sudoku casuale completo
		generate();

		// cancella empty caselle a caso (mettendoci 0)
		hide(empty);
	}

	// restituisce una stringa che descrive il sudoku;
	// si tratta della stampa della matrice 9x9,
	// i cui elementi da 1 a 9 vengono prima trasformati
	// nell'oggetto di tipo E corrispondente, usando la funzione generator,
	// e poi trasformati in stringhe;
	// si inseriscano anche le barrette di separazione orizzontale
	// e verticale fra le 9 regioni del sudoku
	public String toString() {
		String result = "";
		// completare
		return result;
	}

	private final static Random random = new Random();

	// nasconde (cioè pone a 0) esattamente howMany caselle del sudoku,
	// scelte a caso fra quelle che non sono già a 0
	private void hide(int howMany) {
		// completare
	}

	// genera un sudoku risolto (già fatto, non dovete modificare nulla)
	private void generate() {
		generate(0, 0);
	}

	// funzione ausiliaria per generare un sudoku risolto (non modificate)
	private boolean generate(int x, int y) {
		int start = random.nextInt(9);
		int nextX = (x + 1) % 9;
		int nextY = (nextX == 0) ? y + 1 : y;

		for (int num = start; num < start + 9; num++) {
			matrix[x][y] = (num % 9) + 1;
			if (isLegal(x, y) && (nextY == 9 || generate(nextX, nextY)))
				return true;
		}

		matrix[x][y] = 0;

		return false;
	}

	// determina se l'elemento alle coordinate x,y è legale (non modificate)
	private boolean isLegal(int x, int y) {
		return isHorizontallyUnique(x, y)
			&& isVerticallyUnique(x, y)
			&& isUniqueInRegion(x, y);
	}

	// determina se l'elemento alle coordinate x,y è unico nella sua riga
	private boolean isHorizontallyUnique(int x, int y) {
		// completare
	}

	// determina se l'elemento alle coordinate x,y è unico nella sua colonna
	private boolean isVerticallyUnique(int x, int y) {
		// completare
	}

	// determina se l'elemento alle coordinate x,y è duplicato nella sua regione
	private boolean isUniqueInRegion(int x, int y) {
		// completare
	}
}
