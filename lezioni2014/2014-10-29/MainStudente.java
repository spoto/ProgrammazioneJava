
public class MainStudente {

	public static void main(String[] args) {
		Data d = new Data(1750, 5, 23);
		Studente camillo = new Studente("Camillo", "Benso", d);
		System.out.println(camillo.toString());
		Data nascita = camillo.getDataDiNascita();
		nascita.next();
		System.out.println(camillo.toString());
	}

}
