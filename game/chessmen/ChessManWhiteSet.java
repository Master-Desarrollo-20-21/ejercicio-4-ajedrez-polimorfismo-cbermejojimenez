package game.chessmen;

import game.Player;

public class ChessManWhiteSet extends ChessManSet {
	public ChessManWhiteSet(Player owner) {
		this.chessManSet = new ChessManInterface[16];

		this.chessManSet[0] = new ChessManWhite(new ChessManTypePawn(), owner);
		this.chessManSet[1] = new ChessManWhite(new ChessManTypePawn(), owner);
		this.chessManSet[2] = new ChessManWhite(new ChessManTypePawn(), owner);
		this.chessManSet[3] = new ChessManWhite(new ChessManTypePawn(), owner);
		this.chessManSet[4] = new ChessManWhite(new ChessManTypePawn(), owner);
		this.chessManSet[5] = new ChessManWhite(new ChessManTypePawn(), owner);
		this.chessManSet[6] = new ChessManWhite(new ChessManTypePawn(), owner);
		this.chessManSet[7] = new ChessManWhite(new ChessManTypePawn(), owner);
		this.chessManSet[8] = new ChessManWhite(new ChessManTypeRook(), owner);
		this.chessManSet[9] = new ChessManWhite(new ChessManTypeKnight(), owner);
		this.chessManSet[10] = new ChessManWhite(new ChessManTypeBishop(), owner);
		this.chessManSet[11] = new ChessManWhite(new ChessManTypeQueen(), owner);
		this.chessManSet[12] = new ChessManWhite(new ChessManTypeKing(), owner);
		this.chessManSet[13] = new ChessManWhite(new ChessManTypeBishop(), owner);
		this.chessManSet[14] = new ChessManWhite(new ChessManTypeKnight(), owner);
		this.chessManSet[15] = new ChessManWhite(new ChessManTypeRook(), owner);
	}
}
