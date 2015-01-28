package it.univr.spreadsheet;

public class Main {

	public static void main(String[] args) {
		Sheet sheet = new Sheet(5, 6);

		sheet.setCell(1, 0, new NumericConstant(13));
		sheet.setCell(2, 0, new NumericConstant(-45));
		sheet.setCell(1, 1, new NumericConstant(11));
		sheet.setCell(2, 1, new NumericConstant(23));
		sheet.setCell(1, 2, new NumericConstant(1));
		sheet.setCell(2, 2, new NumericConstant(4));
		sheet.setCell(0, 3, new StringConstant("totale:"));
		sheet.setCell(1, 3, new Add(sheet.getCell(1, 0), new Add(sheet.getCell(1, 1), sheet.getCell(1, 2))));
		sheet.setCell(2, 3, new Add(sheet.getCell(2, 0), new Add(sheet.getCell(2, 1), sheet.getCell(2, 2))));
		sheet.setCell(1, 4, new Div(sheet.getCell(2, 3), new NumericConstant(0)));
		sheet.setCell(2, 4, new Append(sheet.getCell(2, 3), sheet.getCell(1, 4)));
		sheet.setCell(3, 4, new Append(sheet.getCell(2, 3), sheet.getCell(0, 3)));
		sheet.setCell(3, 5, new Add(sheet.getCell(0, 1), sheet.getCell(3, 4)));
		//sheet.setCell(1, 0, sheet.getCell(1, 3));

		System.out.println(sheet);
	}
}