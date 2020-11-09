package game.chessmen;

import game.Cell;

public class ChessManTypeKnight extends ChessManType {

	public ChessManTypeKnight() {
		super();
		this.name = "A";
		this.jump = true;
	}

	public boolean isValidMovement(Cell origin, Cell destination, boolean reverseY, boolean firstMovement) {

		int row1 = origin.getRow();
		int row2 = destination.getRow();
		int column1 = origin.getColumn();
		int column2 = destination.getColumn();

		// Two vertical and one horizontal or two horizontal and one vertical, should be
		// 3
		return (Math.abs(row1 - row2) + Math.abs(column1 - column2) == 3);
	}
}
