package game;

import game.chessmen.ChessManInterface;

public class Cell {

	protected int row;
	protected int column;
	protected ChessManInterface chessMan;

	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public ChessManInterface getChessMan() {
		return this.chessMan;
	}

	public void setChessMan(ChessManInterface chessMan) {
		this.chessMan = chessMan;
	}

	public boolean isEmpty() {
		return this.chessMan == null;
	}

	public String toString() {
		if (this.chessMan == null) {
			return "|   ";
		} else {
			return "| " + this.chessMan.getName() + " ";
		}
	}
}
