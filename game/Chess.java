package game;

import game.chessmen.ChessManBlackSet;
import game.chessmen.ChessManWhiteSet;
import game.ui.Console;
import game.ui.UI;

public class Chess {

	protected Board board;
	protected Turn turn;
	protected Result result;
	protected UI ui;

	protected int counter = 0;

	protected Chess(Board board, Turn turn, Result result, UI ui) {
		this.board = board;
		this.turn = turn;
		this.result = result;
		this.ui = ui;
		this.startNewGame();
	}

	protected void play() {
		do {
			Player activePlayer = this.turn.getActivePlayer();

			ui.clear();
			ui.message(this.board.toString());
			ui.message("Turno para ".concat(activePlayer.getName()));

			try {
				Coordinate originCoordinate = new Coordinate(this.ui.waitForClientInput("Coordenada de origen:"));
				Coordinate destinationCoordinate = new Coordinate(this.ui.waitForClientInput("Coordenada de destino:"));

				if (this.board.move(activePlayer, originCoordinate, destinationCoordinate)) {
					activePlayer.increaseMovementsCounter();
					this.turn.togglePlayer();

				} else {
					ui.waitForClientInput("\n\nMOVIMIENTO NO PERMITIDO.\nPulsa una tecla para intentarlo de nuevo.");
				}
			} catch (Exception e) {
				ui.waitForClientInput("\n\nCOORDENADAS NO VÁLIDAS.\nPulsa una tecla para intentarlo de nuevo.");
			}

		} while (!this.result.isCheckMate());

		this.turn.togglePlayer();

		ui.message("JAQUE MATE. GANADOR: " + this.turn.getActivePlayer().getName());
		ui.waitForClientInput("\n\nPulsa una tecla para comenzar de nuevo.");
		this.startNewGame();
	}

	protected void startNewGame() {
		ChessManWhiteSet whiteSet = new ChessManWhiteSet(this.turn.getPlayer(0));
		ChessManBlackSet blackSet = new ChessManBlackSet(this.turn.getPlayer(1));

		this.board.locateChessMen(whiteSet, blackSet);
		this.turn.reset();
		this.play();
	}

	public static void main(String[] args) {
		Board board = new Board();
		Turn turn = new Turn();
		Result result = new Result(board);
		UI ui = new Console();

		new Chess(board, turn, result, ui);
	}
}
