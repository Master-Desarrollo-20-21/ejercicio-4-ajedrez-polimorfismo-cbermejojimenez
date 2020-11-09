package game;

public class Player {

	String name = "";
	int movementsCounter = 0;

	public Player(String name) {
		this.name = name;
	}

	public void increaseMovementsCounter() {
		++this.movementsCounter;
	}

	public int getMovementsCounter() {
		return this.movementsCounter;
	}

	public String getName() {
		return this.name;
	}
}
