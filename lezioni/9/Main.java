
public class Main {

	public static void main(String[] args) {
		Data d = new Data(27, "marzo");
		Data data1 = new Data(13, "gennaio", 1973);
		Data data2 = new Data(32, "gennaio", 1973);
		Data data3 = new Data(13, "brumaio", 1973);
		Data data4 = new Data(30, 3, 1973);

		d.stampa();
		data1.stampa();
		data2.stampa();
		data3.stampa();
		data4.stampa();
		System.out.println(data1.equals(data2));
		System.out.println(data1.equals(data3));
	}

}
