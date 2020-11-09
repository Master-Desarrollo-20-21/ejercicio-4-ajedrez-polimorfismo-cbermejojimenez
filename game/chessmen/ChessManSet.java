package game.chessmen;

public class ChessManSet {
	protected ChessManInterface[] chessManSet = {};

	public ChessManInterface getChessMan(int index) {
		return this.chessManSet[index];
	}

	public boolean isKingAlive() {
		return this.chessManSet[12].getIsAlive();
	}
}
