package game.chessmen;

import game.Cell;

public class ChessManTypePawn extends ChessManType {

	public ChessManTypePawn() {
		super();
		this.name = "P";
	}

	public boolean isValidMovement(Cell origin, Cell destination, boolean reverseY, boolean firstMovement) {

		int row1 = origin.getRow();
		int row2 = destination.getRow();
		int column1 = origin.getColumn();
		int column2 = destination.getColumn();

		boolean result = false;

		// First movement, two ahead allowed
		result |= (firstMovement && !reverseY && (row2 - row1 == 2) && column1 == column2 && destination.isEmpty());
		result |= (firstMovement && reverseY && (row1 - row2 == 2) && column1 == column2 && destination.isEmpty());

		// One ahead to empty cell
		result |= (reverseY == false && (row2 - row1 == 1) && column1 == column2 && destination.isEmpty());
		result |= (reverseY == true && (row1 - row2 == 1) && column1 == column2 && destination.isEmpty());

		// One diagonal ahead on non empty cell
		result |= (!reverseY && (row2 - row1 == 1) && (Math.abs(column1 - column2) == 1) && !destination.isEmpty());
		result |= (reverseY && (row1 - row2 == 1) && (Math.abs(column1 - column2) == 1) && !destination.isEmpty());

		return result;
	}
}
