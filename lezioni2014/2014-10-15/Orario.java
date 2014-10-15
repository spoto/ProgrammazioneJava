
public class Orario {
	private int ora;
	private int minuti;
	private int secondi;
	
	// ha side-effect su this
	public Orario(int ora, int minuti, int secondi) {
		// esegue Orario(ora, minuti);
		this(ora, minuti);

		this.secondi = secondi;
	}

	public Orario(int ora, int minuti) {
		this.ora = ora;
		this.minuti = minuti;
		//this.secondi = 0;
	}

	// non ha side-effect
	public void stampa() {
		System.out.printf("%02d:%02d:%02d\n", ora, minuti, secondi);
	}

	// <0 se viene prima this
	// 0 se sono uguali
	// >0 se viene prima altro
	public int compareTo(Orario altro) {
		int temp = this.ora - altro.ora;
		if (temp != 0)
			return temp;
		
		if ((temp = this.minuti - altro.minuti) != 0)
			return temp;
		
		return this.secondi - altro.secondi;
	}

	// <0 se viene prima this
	// 0 se sono uguali
	// >0 se viene prima altro
	// non ha side-effect
	public int compareTo2(Orario altro) {
		return secondiDallaMezzanotte() - altro.secondiDallaMezzanotte();
	}

	// non ha side-effect
	private int secondiDallaMezzanotte() {
		return secondi + minuti * 60 + ora * 60 * 60;
	}

	// aggiunge "quante" ore a this
	// ha side-effect (su this)
	public void aggiungi(int quanteOre) {
		ora += quanteOre;
	}

	// quantiMinuti è tra 0 e 59
	// ha side-effect (su this)
	public void aggiungi(int quanteOre, int quantiMinuti) {
		ora += quanteOre;
		minuti += quantiMinuti;
		if (minuti > 59) {
			minuti = minuti % 60;
			ora++;
		}
	}
}







