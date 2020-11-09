package game.chessmen;

import game.Cell;

public class ChessManTypeBishop extends ChessManType {

	public ChessManTypeBishop() {
		super();
		this.name = "C";
	}

	public boolean isValidMovement(Cell origin, Cell destination, boolean reverseY, boolean firstMovement) {

		int row1 = origin.getRow();
		int row2 = destination.getRow();
		int column1 = origin.getColumn();
		int column2 = destination.getColumn();

		// Any in diagonal direction
		return (Math.abs(row1 - row2) == Math.abs(column1 - column2));
	}
}
