package com.java42.swingy.app;

import com.java42.swingy.controller.Swingy;
import com.java42.swingy.lib.XPManager.XPManager;
import com.java42.swingy.lib.XPManager.XPManagerFactory;
import com.java42.swingy.lib.map.GameMap;
import com.java42.swingy.lib.map.GameMapFactory;
import com.java42.swingy.lib.save.HeroDAO;
import com.java42.swingy.lib.save.SaveFactory;
import com.java42.swingy.view.View;
import com.java42.swingy.view.ViewFactory;
import com.java42.swingy.view.ViewType;

public class Main {

	public static void main(String[] args) {
		View view = ViewFactory.getView(ViewType.GUI);
		GameMap gameMap = GameMapFactory.getGameMap();
		HeroDAO save = SaveFactory.getSaveMean("save.txt");
		XPManager xpManager = XPManagerFactory.getXPManager();
		Swingy controller = new Swingy(view, gameMap, save, xpManager);
		controller.run();
	}

}
