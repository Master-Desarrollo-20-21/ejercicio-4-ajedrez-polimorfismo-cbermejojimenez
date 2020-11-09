package game.chessmen;

import game.Cell;
import game.Player;

public class ChessManWhite extends ChessMan {
	public ChessManWhite(ChessManTypeInterface type, Player owner) {
		super(type, owner);
	}

	public String getName() {
		return this.type.getName().toUpperCase();
	}

	public boolean isValidMovement(Cell origin, Cell destination, boolean firstMovement) {
		return this.type.isValidMovement(origin, destination, false, firstMovement);
	}
}
