package it.univr.life;

public class Main {

	public static void main(String[] args) {
		Board board = new Board(40, 30, new Blinker(5, 7), new Toad(20, 15), new Block(2, 2), new Ship(35, 20), new Glider(30, 8));

		for (int num = 1; num <= 100; num++) {
			System.out.println("iteration #" + num);
			System.out.println(board);
			System.out.println();

			// aspetta un secondo prima della prossima iterazione
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {}

			board.recomputeCells();
		}
	}
}