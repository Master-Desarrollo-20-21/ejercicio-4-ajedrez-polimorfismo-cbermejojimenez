package game.chessmen;

import game.Cell;

public class ChessManTypeQueen extends ChessManType {

	public ChessManTypeQueen() {
		super();
		this.name = "Q";
	}

	public boolean isValidMovement(Cell origin, Cell destination, boolean reverseY, boolean firstMovement) {

		int row1 = origin.getRow();
		int row2 = destination.getRow();
		int column1 = origin.getColumn();
		int column2 = destination.getColumn();

		// Any in diagonal, vertical or horizontal direction
		return (row1 == row2 || column1 == column2 || Math.abs(row1 - row2) == Math.abs(column1 - column2));
	}
}
