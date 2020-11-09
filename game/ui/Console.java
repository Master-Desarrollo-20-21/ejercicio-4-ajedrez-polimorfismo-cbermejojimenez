package game.ui;

import java.util.Scanner;

public class Console extends UI {
	public String waitForClientInput(String message) {
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		return input.nextLine();
	}

	public void message(String message) {
		System.out.println(message);
	}

	public void clear() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}
}
