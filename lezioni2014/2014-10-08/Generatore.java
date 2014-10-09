import java.util.Random;

public class Generatore {
    public static void main(String[] args) {
	int dentro = 0;
	int fuori = 0;

	for (int estrazione = 1; estrazione <= 1000000; estrazione++) {
	    double x = new Random().nextDouble() * 2 - 1;
	    double y = new Random().nextDouble() * 2 - 1;

	    if (x * x + y * y <= 1)
		dentro++;
	    else
		fuori++;
	}

	System.out.println("dentro: " + dentro);
	System.out.println("fuori: " + fuori);
	System.out.println(4.0 * dentro / (dentro + fuori));
    }
}
