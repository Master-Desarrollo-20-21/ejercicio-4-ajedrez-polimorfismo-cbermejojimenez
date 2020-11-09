package game.chessmen;

import game.Cell;

public abstract class ChessManType implements ChessManTypeInterface {

	protected String name;
	protected boolean jump = false;

	public ChessManType() {
		this.name = "";
	}

	public String getName() {
		return this.name;
	}

	public boolean canJump() {
		return this.jump;
	}

	public boolean isValidMovement(Cell origin, Cell destination, boolean reverseY, boolean firstMovement) {
		return false;
	}
}
