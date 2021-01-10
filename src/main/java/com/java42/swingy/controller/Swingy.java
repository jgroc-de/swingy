package com.java42.swingy.controller;

import com.java42.swingy.lib.XPManager.XPManager;
import com.java42.swingy.lib.map.GameMap;
import com.java42.swingy.lib.save.Save;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.view.GameView;
import com.java42.swingy.view.MenuView;

public class Swingy {
	enum GameState {
		MENU, PLAYING, END
	}

	MenuView menuView;
	Hero hero;
	GameState gameState;
	MenuController menu;
	GamePlayController play;

	public Swingy(MenuView menuView, GameView gameView, GameMap gameMap, Save save, XPManager xpManager) {
		this.menuView = menuView;
		gameView.setController(this);
		gameView.setGameMap(gameMap);
		menuView.setController(this);
		gameState = GameState.MENU;
		menu = new MenuController(menuView, save, this);
		play = new GamePlayController(gameMap, gameView, save, xpManager, this);
	}

	public void run() {
		boolean playing = true;

		menuView.splashScreen();
		while (playing) {
			switch (gameState) {
			case MENU:
				gameState = menu.menuAction(hero);
				break;
			case PLAYING:
				gameState = play.playingAction(hero, hero.getLevel());
				break;
			case END:
				playing = false;
				break;
			default:
				break;
			}
		}
		menuView.quit();
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}
}
