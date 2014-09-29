
public class Persona extends EssereVivente implements Ordinabile {

	private final String nome;
	private final Data dataDiNascita;
	
	public Persona(String nome, Data dataDiNascita) {
		this.nome = nome;
		this.dataDiNascita = dataDiNascita;
	}

	public boolean precede(Ordinabile altra) {
		if (!(altra instanceof Persona))
			return false;

		Persona altraComePersona = (Persona) altra;

		if (dataDiNascita.precede(altraComePersona.dataDiNascita))
			return true;
		else if (!(altraComePersona.getDataDiNascita().precede(dataDiNascita)))
			if (nome.compareTo(altraComePersona.nome) < 0)
				return true;

		return false;
	}

	public String getNome() {
		return nome;
	}

	public Data getDataDiNascita() {
		return dataDiNascita;
	}

	public String toString() {
		return nome + " nato il " + dataDiNascita;
	}
}
