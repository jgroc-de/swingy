package com.java42.swingy.view;

public class ViewFactory {
	public static MenuView getMenuView(int value) {
		if (value == 1) {
			return new CommandLineMenu();
		}
		return new CommandLineMenu();
	}

	public static GameView getGameView(int value) {
		if (value == 1) {
			return new CommandLineGame();
		}
		return new CommandLineGame();
	}
}
