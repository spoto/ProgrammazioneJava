
public class RaceCondition extends Thread {

	private static long nice;
	private static long ugly;
	private static Object lock = new Object();

	@Override
	public void run() {
		for (long count = 0; count < 100000L; count++) {
			synchronized (lock) {
				nice++;
			}

			synchronized (lock) {
				ugly++;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		RaceCondition[] racers = new RaceCondition[100];
		for (int pos = 0; pos < racers.length; pos++)
			racers[pos] = new RaceCondition();
		for (RaceCondition racer: racers)
			racer.start();
		for (RaceCondition racer: racers)
			racer.join();

		System.out.println("nice = " + nice + " ugly = " + ugly);
	}
}
