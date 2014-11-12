
public class GattoScozzese extends Gatto {

	public GattoScozzese(String nome) {
		super(nome);
	}

	public double costo() {
		return 0.01;
	}

	// un gatto scozzese mette sempre
	// "Mc" davanti al suo nome
	protected String getNome() {
		return "Mc" + super.getNome();
	}
}
