import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Semaforo portaNuova = new Semaforo();
		Semaforo portaPalio = new Semaforo();

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("Vuoi cambiare il colore del semaforo 1 o 2? ");
			int risposta = scanner.nextInt();
			if (risposta == 1)
				portaNuova.next();
			else if (risposta == 2)
				portaPalio.next();
			else
				System.out.println("1 o 2");

			System.out.println("Semaforo di Porta Nuova\n"
					+ portaNuova.toString());
			System.out.println("Semaforo di Porta Palio\n"
					+ portaPalio.toString());
		}
		while (true);
}
}
