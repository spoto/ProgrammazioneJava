package it.univr.gioco15.view;

import it.univr.gioco15.controller.Move;
import it.univr.gioco15.controller.SolvedChecker;
import it.univr.gioco15.model.Board;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Game extends JFrame {
	private static final int HEIGHT = 400;
	private static final int WIDTH = 400;

	private final Board board;
	private final CommandWindow commands = new CommandWindow();

	public Game(Board board) {
		super("Play!");

		this.board = board;

		setLayout(new GridLayout(board.getHeight(), board.getWidth()));
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		showBoard();
	}

	private boolean isSolved() {
		return new SolvedChecker(board).isSolved();
	}

	@Override
	public void setVisible(boolean isVisible) {
		super.setVisible(isVisible);

		commands.setVisible(isVisible);
	}

	private void showBoard() {
		for (int y = 0; y < board.getHeight(); y++)
			for (int x = 0; x < board.getWidth(); x++)
				if (board.getNumberAt(x, y) != 0)
					addTile(new NumberedTile(board.getNumberAt(x, y)), x, y);
				else
					addTile(new EmptyTile(), x, y);
	}

	private void addTile(Tile tile, final int x, final int y) {
		add(tile);

		tile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isSolved()) {
					if (new Move(board, x, y).isLegal()) {
						getContentPane().removeAll();
						showBoard();

						if (isSolved())
							commands.setMessage("bravo!");
						else
							commands.setMessage("mossa legale");

						revalidate();
					}
					else
						commands.setMessage("mossa illegale");
				}
			}
		});
	}

	public static void main(String[] args) {
		new Game(new Board(3, 4)).setVisible(true);
	}
}
