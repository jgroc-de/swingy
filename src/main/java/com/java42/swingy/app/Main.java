package com.java42.swingy.app;

import com.java42.swingy.controller.Swingy;
import com.java42.swingy.lib.XPManager.XPManager;
import com.java42.swingy.lib.XPManager.XPManagerFactory;
import com.java42.swingy.lib.map.GameMap;
import com.java42.swingy.lib.map.GameMapFactory;
import com.java42.swingy.lib.save.Save;
import com.java42.swingy.lib.save.SaveFactory;
import com.java42.swingy.view.GameView;
import com.java42.swingy.view.MenuView;
import com.java42.swingy.view.ViewFactory;
import com.java42.swingy.view.ViewType;

public class Main {

	public static void main(String[] args) {
		ViewType viewType = ViewType.COMMANDLINE;
		MenuView menuView = ViewFactory.getMenuView(viewType);
		GameView gameView = ViewFactory.getGameView(viewType);
		GameMap gameMap = GameMapFactory.getGameMap();
		Save save = SaveFactory.getSaveMean("save.txt");
		XPManager xpManager = XPManagerFactory.getXPManager();
		Swingy controller = new Swingy(menuView, gameView, gameMap, save, xpManager);
		controller.run();
	}

}
