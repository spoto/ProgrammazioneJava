package it.univr.sets;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// l'unico metodo di questa interfaccia di libreria "consuma"
// un elemento, cioè è definito come:
// void accept(E element);
// in questo esercizio usiamo questa interfaccia per specificare cosa fare
// quando un elemento viene aggiunto o tolto da un insieme
import java.util.function.Consumer;

// l'unico metodo di questa interfaccia di libreria è una funzione da E a int,
// cioè è definito come:
// int applyAsInt(E element);
// in questo esercizio usiamo questa interfaccia per specificare come inizializzare
// il punteggio degli elementi aggiunti all'insieme
import java.util.function.ToIntFunction;

/**
 * Un insieme i cui elementi hanno un punteggio positivo.
 * E' possibile aggiungere e togliere elementi.
 * E' possibile punire o perdonare un elemento per una cerca quantità di punti,
 * il che significa che il suo punteggio viene ridotto o aumentato
 * di tale quantità (rispettivamente). Se il punteggio diventasse non positivo,
 * l'elemento verrebbe rimosso dall'insieme.
 * Iterando su un oggetto di questa classe si devono ottenere i suoi elementi.
 *
 * @param <E> il tipo degli elementi dell'insieme
 */
public class PunishableSet<E> implements Iterable<E> {

	/**
	 * Gli elementi dell'insieme, con il loro punteggio attuale.
	 */
	private final Map<E, Integer> container = new HashMap<>();

	/**
	 * La funzione che specifica come inizializzare il punteggio
	 * degli elementi, quando vengono aggiunti all'insieme.
	 */
	private final ToIntFunction<E> init;

	/**
	 * Il codice che viene eseguito quando un elemento viene
	 * aggiunto all'insieme.
	 */
	private final Consumer<E> onAdd;

	/**
	 * Il codice che viene eseguito quando un elemento viene
	 * rimosso dall'insieme.
	 */
	private final Consumer<E> onRemove;

	/**
	 * Costruisce un insieme contenente inizialmente esattamente
	 * gli elementi indicati, con il punteggio dato dalla funzione init.
	 * 
	 * @param elements gli elementi iniziali
	 * @param init la funzione (da E a int) usata per inizializzare il punteggio
	 *             degli elementi aggiunti all'insieme
	 * @param onAdd la funzione che verrà chiamata ogni volta che si aggiunge un elemento
	 * @param onRemove la funzione che verrà chiamata ogni volta che si toglie un elemento
	 */
	public PunishableSet(E[] elements, ToIntFunction<E> init, Consumer<E> onAdd, Consumer<E> onRemove) {
		this.init = init;
		this.onAdd = onAdd;
		this.onRemove = onRemove;

		for (E element: elements)
			add(element);
	}

	/**
	 * Costruisce un insieme contenente inizialmente gli elementi indicati,
	 * con il punteggio dato dalla funzione init.
	 * Le funzioni da chiamare in caso di aggiunta o rimozione non fanno nulla
	 * (il che equivale a dire che si usano onAdd e onRemove che dato un
	 * elemento qualsiasi eseguono il codice vuoto {}).
	 * 
	 * @param elements gli elementi iniziali
	 * @param init la funzione (da E a int) usata per inizializzare il punteggio
	 *             degli elementi aggiunti all'insieme
	 */
	public PunishableSet(E[] elements, ToIntFunction<E> init) {
		this(elements, init, _e -> {}, _e -> {});
	}

	/**
	 * Costruisce un insieme contenente inizialmente gli elementi indicati.
	 * Il punteggio di un elemento aggiunto all'insieme è inizialmente 1000
	 * (il che equivale a dire che si usa una init che ritorna sempre 1000).
	 * 
	 * @param elements gli elementi iniziali
	 */
	public PunishableSet(E[] elements) {
		this(elements, _e -> 1000);
	}

	/**
	 * Prova ad aggiungere element all'insieme, con un punteggio iniziale
	 * dato dalla funzione init. Il valore di ritorno indica se
	 * l'elemento è stato aggiunto o meno. Questa funzione dovrebbe
	 * ritornare false solo in due casi: 1) se element fosse già nell'insieme;
	 * oppure 2) se il valore iniziale dato dalla funzione init fosse non
	 * positivo. Nel caso in cui ritorna true, questa funzione esegue
	 * il codice di onAdd.
	 * 
	 * @param element l'elemento da aggiungere
	 * @return true se l'elemento è stato aggiunto; false se l'elemento
	 *         non è stato aggiunto
	 */
	public boolean add(E element) {
		if (!container.containsKey(element)) {
			int initialValue = init.applyAsInt(element);
			if (initialValue > 0) {
				container.put(element, initialValue);
				onAdd.accept(element);
				return true;
			}
		}

		return false;
	}

	/**
	 * Prova ad eliminare element dall'insieme. Il valore di ritorno indica se
	 * l'elemento è stato eliminato o meno. Questa funzione dovrebbe
	 * ritornare false solo se element non fosse già nell'insieme.
	 * Nel caso in cui ritorna true, questa funzione esegue
	 * il codice di onRemove.
	 * 
	 * @param element l'elemento da rimuovere
	 * @return true se l'elemento è stato rimosso; false se l'elemento
	 *         non è stato rimosso
	 */
	public boolean remove(E element) {
		if (container.containsKey(element)) {
			container.remove(element);
			onRemove.accept(element);
			return true;
		}
		else
			return false;
	}

	/**
	 * Punisce element togliendogli points punti. Se, così facendo,
	 * i punti di element diventassero non positivi, questa funzione
	 * rimuove element dall'insieme. Se element non fosse nell'insieme,
	 * questa funzione non ha effetto (oltre all'eventuale eccezione).
	 * 
	 * @param element l'elemento da punire
	 * @param points quanti punti devono venire tolti  element
	 * @throws IllegalArgumentException se points fosse negativo
	 */
	public void punish(E element, int points) {
		if (points < 0)
			throw new IllegalArgumentException("points must be non-negative");

		if (container.containsKey(element)) {
			int newValue = container.get(element) - points;
			if (newValue > 0)
				container.put(element, newValue);
			else
				remove(element);
		}
	}

	/**
	 * Perdona element aggiungendogli points punti.
	 * Se element non fosse nell'insieme,
	 * questa funzione non ha effetto (oltre all'eventuale eccezione).
	 * 
	 * @param element l'elemento da perdonare
	 * @param points quanti punti devono venire aggiunti al punteggio di element
	 * @throws IllegalArgumentException se points fosse negativo
	 */
	public void pardon(E element, int points) {
		if (points < 0)
			throw new IllegalArgumentException("points must be non-negative");

		if (container.containsKey(element)) {
			int newValue = container.get(element) + points;
			container.put(element, newValue);
		}
	}

	/**
	 * Ritorna una stringa che enumera su due colonne gli elementi dell'insieme,
	 * con a lato il loro punteggio (si veda l'esempio nel compito).
	 */
	@Override
	public String toString() {
		String result = "";

		for (E element: this)
			result += element + ": " + container.get(element) + " points\n";

		return result;
	}

	@Override
	public Iterator<E> iterator() {
		return container.keySet().iterator();
	}
}