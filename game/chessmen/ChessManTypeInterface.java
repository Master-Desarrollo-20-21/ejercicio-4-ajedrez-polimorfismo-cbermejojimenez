package game.chessmen;

import game.Cell;

public interface ChessManTypeInterface {
	public String getName();

	public boolean isValidMovement(Cell origin, Cell destination, boolean reverseY, boolean firstMovement);

	public boolean canJump();
}
