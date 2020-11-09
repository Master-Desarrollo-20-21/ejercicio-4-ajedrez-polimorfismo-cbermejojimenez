package game;

public class Row {
	protected final String LETTERS = "ABCDEFGH";
	protected int index;

	protected Cell[] cells = new Cell[8];

	public Row(int index) {

		this.index = index;
		int length = this.LETTERS.length();

		for (int i = 0; i < length; ++i) {
			this.cells[i] = new Cell(index, i);
		}
	}

	public Cell getCellByLetter(String letter) {
		int letterIndex = this.LETTERS.indexOf(letter);
		return (letterIndex != -1) ? this.cells[letterIndex] : null;
	}

	public Cell getCellByIndex(int index) {
		return this.cells[index];
	}

	public String toString() {
		String result = " " + (this.index + 1) + " ";
		for (int i = 0; i < this.cells.length; ++i) {
			result += this.cells[i].toString();
		}
		result += "| " + (this.index + 1) + " \n";
		result += "   ————————————————————————————————\n";
		return result;
	}
}
