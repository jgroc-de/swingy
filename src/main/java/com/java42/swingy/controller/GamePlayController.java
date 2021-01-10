package com.java42.swingy.controller;

import java.util.List;

import com.java42.swingy.controller.Swingy.GameState;
import com.java42.swingy.lib.XPManager.XPManager;
import com.java42.swingy.lib.map.Direction;
import com.java42.swingy.lib.map.GameMap;
import com.java42.swingy.lib.save.Save;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.artifact.ArtifactFactory;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;
import com.java42.swingy.model.vilain.VilainFactory;
import com.java42.swingy.view.GameView;

public class GamePlayController {
	GameMap gameMap;
	GameView gameView;
	Save save;
	XPManager xpManager;
	Swingy controller;

	public GamePlayController(GameMap gameMap, GameView gameView, Save save, XPManager xpManager, Swingy controller) {
		this.gameMap = gameMap;
		this.gameView = gameView;
		this.save = save;
		this.xpManager = xpManager;
		this.controller = controller;
	}

	public GameState playingAction(Hero hero, int level) {
		boolean victory = false;
		Direction direction;
		int mapSize = gameMap.getMapSize(level);
		int nbOfVilains = gameMap.getNbOfVilains(mapSize);
		List<Vilain> vilains = VilainFactory.getVilains(nbOfVilains, level);

		hero.resetLostHP();
		gameMap.setInitialMapPosition(hero, mapSize);
		gameMap.setVilainsPosition(vilains, mapSize);
		while (victory == false && hero.getHP() > 0) {
			gameView.printMap(mapSize, hero, vilains);
			direction = gameView.promptForDirection();
			hero.move(direction.getX(), direction.getY());
			if (gameMap.isOutOfMap(level, hero.getX(), hero.getY())) {
				victory = true;
			} else if (gameMap.isVilainPosition(vilains, hero.getY(), hero.getX())) {
				hero = fightAction(hero, vilains);
			}
		}
		gameView.printEndOfGame(victory);
		if (hero.getHP() <= 0) {
			save.deleteHero(hero);
			hero = null;
		} else {
			hero.resetLostHP();
		}
		controller.setHero(hero);
		save.saveHero(hero);

		return GameState.MENU;
	}

	private Hero fightAction(Hero hero, List<Vilain> vilains) {
		try {
			Vilain vilain = gameMap.getVilainFromPosition(vilains, hero.getY(), hero.getX());
			if (gameView.promptForRun(vilain) && Math.random() > 0.5) {
				gameView.printRun();
				return hero;
			}

			return fight(hero, vilain, vilains);
		} catch (Exception e) {

		}
		return hero;
	}

	private Hero fight(Hero hero, Vilain vilain, List<Vilain> vilains) {
		Artifact artifact = null;

		gameView.printFightBegin(hero, vilain);
		currentFight(hero, vilain);
		gameView.printFightOutCome(hero, vilain);
		if (hero.getHP() > 0) {
			if (Math.random() > 0.5) {
				artifact = ArtifactFactory.getRandomArtifact(vilain.getLevel());
				gameView.printArtifactDropping(artifact);
				hero.setArtifact(artifact);
			}
			vilains.remove(vilain);
			xpManager.addXP(hero, vilain);
			gameView.printXPgot(hero, xpManager.getXP(vilain));
		}

		return hero;
	}

	private void currentFight(Hero hero, Vilain vilain) {
		int heroHPlost, vilainHPlost;
		int i = 0;
		while (hero.getHP() > 0 && vilain.getHP() > 0) {
			vilainHPlost = hero.getAttack() * (int) (Math.random() + 0.75)
					- vilain.getDefense() * (int) (Math.random() + 0.4);
			vilain.addLostHP(vilainHPlost);
			heroHPlost = vilain.getAttack() * (int) (Math.random() + 0.5)
					- hero.getDefense() * (int) (Math.random() + 0.75);
			hero.addLostHP(heroHPlost);
			gameView.printFight(++i, hero, vilain, heroHPlost, vilainHPlost);
		}
	}
}
