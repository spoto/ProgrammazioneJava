package it.univr.supermarket;

public class Main {
	public static void main(String[] args) {
		long now = System.currentTimeMillis();

		// la mozzarella costa 4 euro e 50 centesimi,
		// e' prodotta adesso e scade 6 giorni dopo la produzione
		Product p1 = new ProductWithExpiration("mozzarella", 4.5, now, 6);

		Product p2 = new ProductWithExpiration("pane", 1, now, 3);
		Product p3 = new ProductWithExpiration("acqua", 2.2, now, 500);
		Product p4 = new ProductWithExpiration("carote", 2, now, 5);
		Product p5 = new ProductWithExpiration("uova", 2.5, now, 10);
		Product p6 = new ProductWithExpiration("pane", 1.2, now, 2);
		Product p7 = new ProductWithExpiration("cipolle", 1.7, now, 5);

		// uno strano prodotto, gia' scaduto al momento della produzione
		Product p8 = new ProductWithExpiration("melone marcio", 3, now, 0);

		// prodotti che non scadono
		Product p9 = new ProductNotExpiring("dentifricio", 2.98);
		Product p10 = new ProductNotExpiring("bagnoschiuma", 4.9);

		// crea un supermercato con 10 prodotti
		Supermarket sm = new Supermarket();
		sm.add(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);

		// stampa il supermercato nella settimana da now in avanti
		printOneWeek(sm, now);
	}

	/**
	 * Stampa sette volte il supermercato indicato, all'inizio di ogni giorno di una
	 * settimana che comincia al tempo start. Questo vuol dire che questo metodo
	 * stampera' il supermercato:
	 * 
	 * al tempo start
	 * al tempo start + 1 giorno
	 * al tempo start + 2 gioni
	 * al tempo start + 3 gioni
	 * al tempo start + 4 gioni
	 * al tempo start + 5 gioni
	 * al tempo start + 6 giorni
	 * 
	 * @param sm il supermercato da stampare
	 * @param start il tempo a cui si inizia a stampare il supermercato
	 */
	private static void printOneWeek(Supermarket sm, long start) {
		// TODO
	}
}