import java.util.Random;

/**
 * A transformer of food into thought.
 * <br>
 * He needs two {@code Fork}s to eat.
 * 
 * @author <A HREF="mailto:fausto.spoto@univr.it">Fausto Spoto</A>
 */

public class Philosopher extends Thread {

	/**
	 * The time required to think or eat.
	 */

	private static final int DELAY = 1;

	/**
	 * A random number generator, used to sleep or eat for
	 * randomly chosen amounts of time.
	 */

	private final static Random random = new Random();

	/**
	 * The name of this philosopher.
	 */

	private final String name;

	/**
	 * The first fork.
	 */

	private final Fork left;

	/**
	 * The second fork.
	 */

	private final Fork right;

	/**
	 * Builds a philosopher.
	 *
	 * @param name
	 * 			the name of the philosopher
	 * @param left
	 * 			its left fork
	 * @param right
	 * 			its right fork
	 */

	public Philosopher(String name, Fork left, Fork right) {
		this.name = name;

		if (left.compareTo(right) < 0) {
			this.left = left;
			this.right = right;
		}
		else {
			this.left = right;
			this.right = left;
		}
	}

	/**
	 * The life of a philosopher is very nice:
	 * 
	 * <ul>
	 * <li> they think
	 * <li> they pick up their two forks
	 * <li> they eat
	 * <li> they start thinking again
	 * </ul>
	 * 
	 * Not surprisingly, philosophers are very fat.
	 */

	@Override
	public void run() {
		while (true) {
			think();

			synchronized (left) {
				System.out.println(name + " picks up " + left);
				synchronized (right) {
					System.out.println(name + " picks up " + right);
					eat();
				}
				System.out.println(name + " puts down " + right);
			}
			System.out.println(name + " puts down " + left);
		}
	}

	/**
	 * Makes this philosopher <i>think</i> for a while.
	 */

	private void think() {
		System.out.println(name + " thinks");

		try {
			sleep(random.nextInt(DELAY));
		}
		catch (InterruptedException e) {}

		System.out.println(name + " stops thinking");
	}

	/**
	 * Makes this philosopher <i>eat</i> for a while.
	 */

	private void eat() {
		System.out.println(name + " eats");
		try {
			sleep(random.nextInt(DELAY));
		}
		catch (InterruptedException e) {}		

		System.out.println(name + " stops eating");
	}
}