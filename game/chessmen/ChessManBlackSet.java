package game.chessmen;

import game.Player;

public class ChessManBlackSet extends ChessManSet {

	public ChessManBlackSet(Player owner) {
		this.chessManSet = new ChessManInterface[16];

		this.chessManSet[0] = new ChessManBlack(new ChessManTypePawn(), owner);
		this.chessManSet[1] = new ChessManBlack(new ChessManTypePawn(), owner);
		this.chessManSet[2] = new ChessManBlack(new ChessManTypePawn(), owner);
		this.chessManSet[3] = new ChessManBlack(new ChessManTypePawn(), owner);
		this.chessManSet[4] = new ChessManBlack(new ChessManTypePawn(), owner);
		this.chessManSet[5] = new ChessManBlack(new ChessManTypePawn(), owner);
		this.chessManSet[6] = new ChessManBlack(new ChessManTypePawn(), owner);
		this.chessManSet[7] = new ChessManBlack(new ChessManTypePawn(), owner);
		this.chessManSet[8] = new ChessManBlack(new ChessManTypeRook(), owner);
		this.chessManSet[9] = new ChessManBlack(new ChessManTypeKnight(), owner);
		this.chessManSet[10] = new ChessManBlack(new ChessManTypeBishop(), owner);
		this.chessManSet[11] = new ChessManBlack(new ChessManTypeQueen(), owner);
		this.chessManSet[12] = new ChessManBlack(new ChessManTypeKing(), owner);
		this.chessManSet[13] = new ChessManBlack(new ChessManTypeBishop(), owner);
		this.chessManSet[14] = new ChessManBlack(new ChessManTypeKnight(), owner);
		this.chessManSet[15] = new ChessManBlack(new ChessManTypeRook(), owner);
	}
}
