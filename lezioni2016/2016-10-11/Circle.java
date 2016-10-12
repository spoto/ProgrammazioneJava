import java.util.Random;

public class Circle {
    public static void main(String[] args) {
	Random random = new Random();
	int inside = 0, outside = 0;

	for (int counter = 0; counter < 10000000; counter++) {
	    double x = random.nextDouble() * 2 - 1;
	    double y = random.nextDouble() * 2 - 1;
	    double distance = Math.sqrt(x * x + y * y); // teorema di Pitagora

	    if (distance <= 1.0)
		inside++;
	    else
		outside++;
	}

	System.out.println("dentro: " + inside);
	System.out.println("fuori: " + outside);

	double pi = 4 / (((double) outside) / inside + 1);
	System.out.println(pi);
    }
}
