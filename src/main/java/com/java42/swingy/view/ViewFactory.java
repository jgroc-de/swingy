package com.java42.swingy.view;

import com.java42.swingy.view.commandLine.CommandLineGame;
import com.java42.swingy.view.commandLine.CommandLineMenu;
import com.java42.swingy.view.gui.GuiGame;
import com.java42.swingy.view.gui.GuiMenu;

public class ViewFactory {
	public static MenuView getMenuView(ViewType viewType) {
		if (viewType == ViewType.COMMANDLINE) {
			return new CommandLineMenu();
		}
		return new GuiMenu();
	}

	public static GameView getGameView(ViewType viewType) {
		if (viewType == ViewType.COMMANDLINE) {
			return new CommandLineGame();
		}
		return new GuiGame();
	}
}
