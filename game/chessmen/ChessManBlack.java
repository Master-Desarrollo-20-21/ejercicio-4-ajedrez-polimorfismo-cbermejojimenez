package game.chessmen;

import game.Cell;
import game.Player;

public class ChessManBlack extends ChessMan {
	public ChessManBlack(ChessManTypeInterface type, Player owner) {
		super(type, owner);
	}

	public String getName() {
		return this.type.getName().toLowerCase();
	}

	public boolean isValidMovement(Cell origin, Cell destination, boolean firstMovement) {
		return this.type.isValidMovement(origin, destination, true, firstMovement);
	}
}
