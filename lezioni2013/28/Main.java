import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		boolean legale = false;

		do {
			int g, m ,a;
			Scanner tastiera = new Scanner(System.in);

			try {
				System.out.print("giorno: ");
				g = tastiera.nextInt();
				System.out.print("mese: ");
				m = tastiera.nextInt();
				System.out.print("anno: ");
				a = tastiera.nextInt();

				System.out.println(new Data(g, m, a));
				legale = true;
			}
			catch (DataIllegaleException e) {
				System.out.println("hai inserito una data illegale");
				System.out.println("messaggio: " + e.getMessage());
			}
			catch (java.util.InputMismatchException e) {
				System.out.println("devi inserire numeri!");
				tastiera.nextLine();
				//continue;
			}
			finally {
				tastiera.close();
			}
		}
		while (!legale);
	}

}
