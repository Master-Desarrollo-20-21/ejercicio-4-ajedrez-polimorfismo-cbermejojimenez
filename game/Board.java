package game;

import game.chessmen.ChessManInterface;
import game.chessmen.ChessManSet;

public class Board {
	protected final int NUMBER_OF_ROWS = 8;
	protected Row[] rows = new Row[this.NUMBER_OF_ROWS];
	ChessManSet whiteSet;
	ChessManSet blackSet;

	public Board() {
		for (int i = 0; i < this.NUMBER_OF_ROWS; i++) {
			this.rows[i] = new Row(i);
		}
	}

	public void locateChessMen(ChessManSet whiteSet, ChessManSet blackSet) {
		this.whiteSet = whiteSet;
		this.blackSet = blackSet;

		for (int i = 0; i < 8; ++i) {
			this.rows[1].getCellByIndex(i).setChessMan(this.whiteSet.getChessMan(i));
			this.rows[0].getCellByIndex(i).setChessMan(this.whiteSet.getChessMan(i + 8));
			this.rows[6].getCellByIndex(i).setChessMan(this.blackSet.getChessMan(i));
			this.rows[7].getCellByIndex(i).setChessMan(this.blackSet.getChessMan(i + 8));
		}
	}

	public boolean move(Player player, Coordinate originCoordinate, Coordinate destinationCoordinate) {
		Cell originCell = this.getCell(originCoordinate);
		Cell destinationCell = this.getCell(destinationCoordinate);

		if (originCell == null || destinationCell == null) {
			return false;
		}

		ChessManInterface originChessMan = originCell.getChessMan();
		ChessManInterface destinationChessMan = destinationCell.getChessMan();

		if (originChessMan == null || originChessMan.getOwner() != player) {
			return false;
		}

		if (!originChessMan.canJump() && !this.getRouteIsEmpty(player, originCell, destinationCell)) {
			return false;
		}

		boolean isFirstMovement = player.getMovementsCounter() == 0;

		if (originChessMan.isValidMovement(originCell, destinationCell, isFirstMovement)) {

			originCell.setChessMan(null);

			if (destinationChessMan != null) {
				destinationChessMan.setIsAlive(false);
			}

			destinationCell.setChessMan(originChessMan);
			return true;
		}
		return false;
	}

	protected boolean getRouteIsEmpty(Player player, Cell originCell, Cell destinationCell) {
		Cell cellStartRows = (originCell.getRow() < destinationCell.getRow()) ? originCell : destinationCell;
		Cell cellEndRows = (originCell.getRow() > destinationCell.getRow()) ? originCell : destinationCell;
		Cell cellStartColumns = (originCell.getColumn() < destinationCell.getColumn()) ? originCell : destinationCell;
		Cell cellEndColumns = (originCell.getColumn() > destinationCell.getColumn()) ? originCell : destinationCell;

		boolean diagonalMode = (originCell.getRow() - destinationCell.getRow()) == (originCell.getColumn()
				- destinationCell.getColumn());
		boolean checkRowsFirst = (destinationCell.getRow() - originCell.getRow()) > (destinationCell.getColumn()
				- originCell.getColumn());

		if (diagonalMode) {
			System.out.println("Modo diagonal");

			int difference = Math.abs(cellStartRows.getRow() - cellEndRows.getRow());

			System.out.println("Diferencia: " + difference);

			for (int i = 0; i <= difference; i++) {

				System.out.println("Revisando row: " + (cellStartRows.getRow() + i) + " column: "
						+ (cellStartColumns.getColumn() + i));

				Cell checkCell = this.rows[cellStartRows.getRow() + i].getCellByIndex(cellStartColumns.getColumn() + i);
				if (checkCell != originCell && checkCell.getChessMan() != null && (checkCell != destinationCell
						|| (checkCell == destinationCell && checkCell.getChessMan().getOwner() == player))) {
					return false;
				}
			}
		} else {
			int differenceRows = Math.abs(cellStartRows.getRow() - cellEndRows.getRow());
			int differenceColumns = Math.abs(cellStartColumns.getRow() - cellEndColumns.getRow());

			System.out.println("Modo NO DIAGONAL");

			if (checkRowsFirst) {
				System.out.println("checkRowsFirst");
				System.out.println("Diferencia: " + differenceRows);

				for (int i = 0; i < differenceRows; ++i) {

					System.out.println("Revisando row: " + (cellStartRows.getRow() + i) + " column: "
							+ (cellStartColumns.getColumn()));

					Cell checkCell = this.rows[cellStartRows.getRow() + i].getCellByIndex(cellStartColumns.getColumn());
					if (checkCell != originCell && checkCell.getChessMan() != null && (checkCell != destinationCell
							|| (checkCell == destinationCell && checkCell.getChessMan().getOwner() == player))) {
						return false;
					}
				}

				for (int i = 1; i < differenceColumns; ++i) {
					Cell checkCell = this.rows[cellEndRows.getRow()].getCellByIndex(cellStartColumns.getColumn() + i);
					if (checkCell.getChessMan() != null && (checkCell != destinationCell
							|| (checkCell == destinationCell && checkCell.getChessMan().getOwner() == player))) {
						return false;
					}
				}
			} else {
				for (int i = 1; i < differenceColumns; ++i) {
					Cell checkCell = this.rows[cellStartRows.getRow()].getCellByIndex(cellStartColumns.getColumn() + i);
					if (checkCell.getChessMan() != null && (checkCell != destinationCell
							|| (checkCell == destinationCell && checkCell.getChessMan().getOwner() == player))) {
						return false;
					}
				}

				for (int i = 1; i < differenceRows; ++i) {
					Cell checkCell = this.rows[cellStartRows.getRow() + i].getCellByIndex(cellEndColumns.getColumn());
					if (checkCell.getChessMan() != null && (checkCell != destinationCell
							|| (checkCell == destinationCell && checkCell.getChessMan().getOwner() == player))) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public Cell getCell(Coordinate coordinate) {
		try {
			return this.rows[coordinate.getY() - 1].getCellByLetter(coordinate.getX());
		} catch (Exception e) {
			return null;
		}
	}

	public ChessManSet getWhiteSet() {
		return this.whiteSet;
	}

	public ChessManSet getBlackSet() {
		return this.blackSet;
	}

	public String toString() {

		String result = "     A   B   C   D   E   F   G   H \n";
		result += "   ————————————————————————————————\n";

		for (int i = 0; i < this.NUMBER_OF_ROWS; ++i) {
			result = result.concat(this.rows[i].toString());
		}

		result += "\n";
		return result;
	}
}
