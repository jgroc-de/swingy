package com.java42.swingy.controller;

import java.util.List;

import com.java42.swingy.heroTypes.HeroFactory;
import com.java42.swingy.map.Direction;
import com.java42.swingy.map.GameMap;
import com.java42.swingy.model.Hero;
import com.java42.swingy.save.Save;
import com.java42.swingy.view.GameView;
import com.java42.swingy.view.MenuItem;
import com.java42.swingy.view.MenuView;

public class Controller {
	enum GameState {
		MENU, PLAYING, END
	}

	MenuView menuView;
	GameView gameView;
	GameMap gameMap;
	Hero hero;
	GameState gameState;
	Save save;

	public Controller(MenuView menuView, GameView gameView, GameMap gameMap, Save save) {
		this.menuView = menuView;
		this.gameView = gameView;
		this.gameMap = gameMap;
		gameView.setController(this);
		menuView.setController(this);
		gameState = GameState.MENU;
		this.save = save;
	}

	public void run() {
		boolean playing = true;
		while (playing) {
			switch (gameState) {
			case MENU:
				menuAction();
				break;
			case PLAYING:
				playingAction();
				save.saveHero(hero);
				break;
			case END:
				playing = false;
			default:
				break;
			}
		}
		menuView.quit();
	}

	private void menuAction() {
		boolean heroIsSet = hero != null;
		MenuItem choice = menuView.promptForMenuAction(heroIsSet);
		switch (choice) {
		case HERO_CREATION:
			heroCreation();
			save.saveHero(hero);
			break;
		case HERO_SELECTION:
			heroSelection();
			break;
		case PLAY:
			menuView.startPlaying(hero);
			if (hero != null) {
				gameState = GameState.PLAYING;
			} else {
				gameState = GameState.MENU;
			}
			break;
		case QUIT:
			gameState = GameState.END;
			break;
		default:
			break;
		}
	}

	private void playingAction() {
		boolean victory = false;
		Direction direction;
		int mapSize = gameMap.getMapSize(hero.getLevel());
		gameMap.setInitialMapPosition(hero);
		while (victory == false || hero.getHP() <= 0) {
			gameView.printMap(mapSize, hero.getX(), hero.getY());
			direction = gameView.promptForDirection();
			hero.move(direction.getX(), direction.getY());
			if (gameMap.isOutOfMap(hero.getLevel(), hero.getX(), hero.getY())) {
				victory = true;
			}
		}
		gameView.printEndOfGame(victory);
		gameState = GameState.MENU;
	}

	private void heroCreation() {
		int heroType = menuView.promptForHeroType();
		int heroID = save.getNextId();
		String name = menuView.promptForHeroName();
		hero = HeroFactory.createHero(heroType, heroID, name);
		menuView.printHero(hero);
		gameState = GameState.MENU;
	}

	private void heroSelection() {
		List<Hero> heroes = save.getAllHeroes();
		int heroIndex;
		if (heroes.isEmpty()) {
			menuView.printHeroListIsEmpty();
		} else {
			heroIndex = menuView.promptForHeroSelection(heroes);
			try {
				hero = heroes.get(heroIndex);
			} catch (Exception e) {

			}
		}
		gameState = GameState.MENU;
	}
}
