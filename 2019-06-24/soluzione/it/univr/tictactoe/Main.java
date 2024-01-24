package it.univr.tictactoe;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Player alessandra = new Player("Alessandra");
		Player giovanni = new Player("Giovanni");

		TicTacToe tictactoe = new FullTicTacToe();
		Player currentPlayer = alessandra;
		System.out.println(tictactoe);

		try (Scanner keyboard = new Scanner(System.in)) {
			do {
				int x, y;

				System.out.println("Gioca " + currentPlayer);
				System.out.print("x: "); x = keyboard.nextInt();
				System.out.print("y: "); y = keyboard.nextInt();

				try {
					tictactoe.play(currentPlayer, x, y);
					currentPlayer = currentPlayer == alessandra ? giovanni : alessandra;
					System.out.println("\n" + tictactoe);
				}
				catch (IllegalArgumentException | IllegalStateException e) {
					System.out.println(e.getMessage());
				}
			}
			while (!tictactoe.isGameOver());
		}
	}
}