package game;

public class Coordinate {

	protected String x;
	protected int y;

	public Coordinate(String name) throws Exception {
		try {
			if (name.length() != 2) {
				throw new Exception("Coordenada no válida.");
			}

			this.x = Character.toString(name.charAt(0));
			this.y = Integer.parseInt(Character.toString(name.charAt(1)));
		} catch (Exception e) {
			throw new Exception("Coordenada no válida.");
		}
	}

	public String getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}
