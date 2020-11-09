package game;

public class Turn {

	protected Player[] players = new Player[2];
	protected int activePlayerIndex = 0;

	public Turn() {
		this.players[0] = new Player("Player 1 (WHITE)");
		this.players[1] = new Player("Player 2 (BLACK)");
	}

	public Player togglePlayer() {
		this.activePlayerIndex ^= 1;
		return this.players[this.activePlayerIndex];
	}

	public Player getPlayer(int playerIndex) {
		return this.players[playerIndex];
	}

	public Player getActivePlayer() {
		return this.players[this.activePlayerIndex];
	}

	public void reset() {
		this.activePlayerIndex = 0;
	}
}
