package game.chessmen;

import game.Cell;

public class ChessManTypeRook extends ChessManType {

	public ChessManTypeRook() {
		super();
		this.name = "T";
	}

	public boolean isValidMovement(Cell origin, Cell destination, boolean reverseY, boolean firstMovement) {

		int row1 = origin.getRow();
		int row2 = destination.getRow();
		int column1 = origin.getColumn();
		int column2 = destination.getColumn();

		// Any in vertical or horizontal direction
		return ((row1 == row2 && column1 != column2) || (row1 != row2 && column1 == column2));
	}
}
