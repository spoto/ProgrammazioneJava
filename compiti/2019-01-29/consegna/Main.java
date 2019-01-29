import it.univr.rent.Agency;
import it.univr.rent.License;
import it.univr.rent.Model;

public class Main {

	public static void main(String[] args) {
		Model captur = new Car("Renault Captur", 75);
		Model panda = new Car("Fiat Panda plus", 30);
		Model iliade = new Bus("Renault Iliade", 500);
		Model pan = new Motorbike("HD Pan American", 75);
		Model pandino = new Car("Fiat Panda", 28);
		Model pandango = new Car("Fiat Panda plus", 30);
		
		Agency hartz = new Agency("Hartz", captur, iliade, panda, pan, pandino);
		System.out.println(hartz);

		for (License license: License.values())
			printModelsFor(license, hartz);
		
		hartz.rent(captur, License.C, 3);
		hartz.rent(panda, License.B, 2);
		hartz.rent(pandango, License.C, 2);
		System.out.println("\nMost rented model: " + hartz.mostRented());

		try {
			hartz.rent(iliade, License.B, 5);
		}
		catch (IllegalLicenseException e) {
			System.out.println("Cannot rent " + iliade + " with license " + License.B);
		}
	}

	private static void printModelsFor(License license, Agency agency) {
		System.out.println("Models available with license " + license);
		System.out.println(agency.modelsAvailableForLicense(license));
	}
}