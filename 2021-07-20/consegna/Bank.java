package it.univr.bank;

// CONSEGNATE I .java INVIANDOLI A fausto.spoto@univr.it

// Create un nuovo progetto Java con un package it.univr.banks dentro il quale
// copiate questa interfaccia.

// Realizzate l'eccezione controllata BankException.java.

// Realizzate un'implementazione SimpleBank.java di Bank.java,
// seguendo la specifica dei commenti dei metodi.

// Realizzate una sottoclasse BankWithMinimum.java di SimpleBank.java che si comporta in
// maniera identica a SimpleBank.java ma che in piu' genera una IllegalArgumentException se si
// cerca di creare un conto corrente con meno di 100 euro o di lasciare meno di 100 euro
// su un conto corrente. SUGGERIMENTO: dovete ridefinire i metodi deposit, withdraw e transfer.
//
// I CAMPI DEVONO ESSERE PRIVATI. SI POSSONO AGGIUNGERE METODI PROTECTED O PRIVATE

/*
Se tutto e' corretto, l'esecuzione del main deve stampare:

Utilizzo una it.univr.bank.SimpleBank
Fausto ha in banca 108.0 euro
Giovanna ha in banca 194.49 euro
Adesso Fausto ritira 87 euro dal suo conto
Fausto adesso ha in banca 21.0 euro

Utilizzo una it.univr.bank.BankWithMinimum
Fausto ha in banca 108.0 euro
Giovanna ha in banca 194.49 euro
Adesso Fausto ritira 87 euro dal suo conto
Exception in thread "main" java.lang.IllegalArgumentException: bisogna lasciare almeno 100 euro sul conto

*/

public interface Bank {

	/**
	 * Ritorna la quantita' di soldi depositati in un conto corrente.
	 * 
	 * @param account una stringa che identifica il conto corrente
	 * @return la quantita' di soldi
	 * @throws IllegalArgumentException se account e' null
	 * @throws BankException se account non esiste in questa banca 
	 */
	double balanceOf(String account) throws BankException;

	/**
	 * Aggiunge una quantita' di soldi a un conto corrente.
	 * 
	 * @param to il conto corrente; se non esisteva in questa banca, viene creato
	 * @param amount la quantita' di soldi da aggiungere
	 * @throws IllegalArgumentException se to e' null oppure amount e' negativo
	 */
	void deposit(String to, double amount);

	/**
	 * Preleva una quantita' di soldi da un conto corrente.
	 * 
	 * @param from il conto corrente
	 * @param amount la quantita' di soldi da prelevare
	 * @throws IllegalArgumentException se from e' null oppure amount e' negativo
	 * @throws BankException se from non esiste in questa banca oppure
	 *         ha depositati meno di amount soldi
	 */
	void withdraw(String from, double amount) throws BankException;

	/**
	 * Sposta una quantita' di soldi da un conto corrente a un altro.
	 * 
	 * @param from il conto corrente di partenza
	 * @param to il conto corrente di destinazione; se non esisteva in questa banca, viene creato
	 * @param amount la quantita' di soldi da spostare
	 * @throws IllegalArgumentException se from e' null oppure to e' null oppure amount e' negativo
	 * @throws BankException se from non esiste in questa banca oppure
	 *         ha depositati meno di amount soldi
	 */
	void transfer(String from, String to, double amount) throws BankException;

	public static void main(String[] args) {
		Bank b1 = new SimpleBank();
		test(b1);
		Bank b2 = new BankWithMinimum();
		test(b2);
	}

	private static void test(Bank bank) {
		System.out.println("\nUtilizzo una " + bank.getClass().getName());

		bank.deposit("Fausto", 120.50);
		bank.deposit("Giovanna", 181.99);

		try {
			bank.transfer("Fausto", "Giovanna", 12.50);
			System.out.println("Fausto ha in banca " + bank.balanceOf("Fausto") + " euro");
			System.out.println("Giovanna ha in banca " + bank.balanceOf("Giovanna") + " euro");
			System.out.println("Adesso Fausto ritira 87 euro dal suo conto");
			bank.withdraw("Fausto", 87);
			System.out.println("Fausto adesso ha in banca " + bank.balanceOf("Fausto") + " euro");
		}
		catch (BankException e) {
			System.out.println("si e' verificata una BankException");
		}
	}
}
