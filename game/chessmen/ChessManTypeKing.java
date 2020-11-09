package game.chessmen;

import game.Cell;

public class ChessManTypeKing extends ChessManType {

	public ChessManTypeKing() {
		super();
		this.name = "R";
	}

	public boolean isValidMovement(Cell origin, Cell destination, boolean reverseY, boolean firstMovement) {

		int row1 = origin.getRow();
		int row2 = destination.getRow();
		int column1 = origin.getColumn();
		int column2 = destination.getColumn();

		// One in any direction
		return (Math.abs(row1 - row2) <= 1) && (Math.abs(column1 - column2) <= 1);
	}
}
