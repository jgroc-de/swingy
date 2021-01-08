package com.java42.swingy.app;

import com.java42.swingy.controller.Controller;
import com.java42.swingy.map.GameMap;
import com.java42.swingy.save.Save;
import com.java42.swingy.save.SaveFactory;
import com.java42.swingy.view.GameView;
import com.java42.swingy.view.MenuView;
import com.java42.swingy.view.ViewFactory;

public class Swingy {

	public static void main(String[] args) {
		MenuView menuView = ViewFactory.getMenuView(1);
		GameView gameView = ViewFactory.getGameView(1);
		GameMap gameMap = new GameMap();
		Save save = SaveFactory.getSaveMean("save.txt");
		Controller controller = new Controller(menuView, gameView, gameMap, save);
		controller.run();
	}

}
