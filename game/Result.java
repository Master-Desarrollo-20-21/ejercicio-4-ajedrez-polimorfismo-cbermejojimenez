package game;

public class Result {
	protected Board board;

	public Result(Board board) {
		this.board = board;
	}

	public boolean isCheckMate() {
		return (!this.board.getWhiteSet().isKingAlive() || !this.board.getBlackSet().isKingAlive());
	}

}
