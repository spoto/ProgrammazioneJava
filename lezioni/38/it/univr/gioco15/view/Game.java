package it.univr.gioco15.view;

import it.univr.gioco15.model.Board;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Game extends JFrame {
	private static final int HEIGHT = 400;
	private static final int WIDTH = 400;

	private Board board;
	private final CommandWindow commands = new CommandWindow();

	public Game(Board board) {
		super("Gioco del 15");

		setLayout(new GridLayout(board.getWidth(), board.getHeight()));
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBoard(board);
	}

	@Override
	public void setVisible(boolean isVisible) {
		super.setVisible(isVisible);

		commands.setVisible(true);
	}

	private void setBoard(Board board) {
		this.board = board;

		for (int i = 0; i < board.getWidth(); i++)
			for (int j = 0; j < board.getHeight(); j++)
				if (board.getNumberAt(i, j) != 0)
					addTile(new NumberedTile(board.getNumberAt(i, j)));
				else
					addTile(new EmptyTile());
	}

	private void addTile(final Tile tile) {
		add(tile);

		tile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				commands.setMessage("hai cliccato su " + tile.toString());
			}
		});
	}

	public static void main(String[] args) {
		new Game(new Board(4, 4)).setVisible(true);
	}
}