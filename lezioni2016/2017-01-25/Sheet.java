public class Sheet {
	private final Cell[][] cells;

	public Sheet(int width, int height) {
		cells = new Cell[width][height];
		
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
				cells[i][j] = new Cell();
	}

	public void setCell(int x, int y, Exp exp) {
		cells[x][y].setExp(exp);
	}

	public Cell getCell(int x, int y) {
		return cells[x][y];
	}

	@Override
	public String toString() {
		String result = "";
		for (int y = 0; y < cells[0].length; y++) {
			result += "|";
			for (int x = 0; x < cells.length; x++) {
				String content = cells[x][y].toString();
				if (content.length() > 10) content = content.substring(0, 10);
				result += String.format("%10s|", content);
			}
			result += "\n";
		}
		return result;
	}
}