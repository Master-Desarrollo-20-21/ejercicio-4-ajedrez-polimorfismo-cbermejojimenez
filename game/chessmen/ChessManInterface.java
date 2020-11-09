package game.chessmen;

import game.Cell;
import game.Player;

public interface ChessManInterface {
	public boolean getIsAlive();

	public void setIsAlive(boolean isAlive);

	public boolean isValidMovement(Cell origin, Cell destination, boolean firstMovement);

	public Player getOwner();

	public String getName();

	public boolean canJump();
}
