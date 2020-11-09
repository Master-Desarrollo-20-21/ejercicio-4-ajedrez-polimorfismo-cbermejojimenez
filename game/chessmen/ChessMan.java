package game.chessmen;

import game.Cell;
import game.Player;

abstract class ChessMan implements ChessManInterface {

	protected boolean isAlive = true;
	protected ChessManTypeInterface type;
	protected Player owner;

	public ChessMan(ChessManTypeInterface type, Player owner) {
		this.type = type;
		this.owner = owner;
	}

	public Player getOwner() {
		return this.owner;
	}

	public boolean getIsAlive() {
		return this.isAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean canJump() {
		return this.type.canJump();
	}

	public boolean isValidMovement(Cell origin, Cell destination, boolean firstMovement) {
		return false;
	}
}
