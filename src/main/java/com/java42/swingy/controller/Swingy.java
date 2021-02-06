package com.java42.swingy.controller;

import com.java42.swingy.lib.XPManager.XPManager;
import com.java42.swingy.lib.map.SquareMap;
import com.java42.swingy.lib.save.HeroDAO;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.view.View;

public class Swingy {
	View menuView;
	MenuController menu;
	GamePlayController play;

	public Swingy(View view, SquareMap gameMap, HeroDAO save, XPManager xpManager) {
		this.menuView = view;
		view.setGameMap(gameMap);
		menu = new MenuController(view, save, this);
		play = new GamePlayController(gameMap, view, save, xpManager, this);
	}

	public void run() {
		menuView.splashScreen();
		menu(null);
	}

	public void menu(Hero hero) {
		menu.menuAction(hero);
	}

	public void play(Hero hero) {
		play.playingAction(hero, hero.getLevel());
	}
}
