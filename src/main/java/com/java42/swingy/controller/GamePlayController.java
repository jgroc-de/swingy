package com.java42.swingy.controller;

import java.util.List;

import com.java42.swingy.lib.XPManager.XPManager;
import com.java42.swingy.lib.map.GameMap;
import com.java42.swingy.lib.save.HeroDAO;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.artifact.ArtifactFactory;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;
import com.java42.swingy.model.vilain.VilainFactory;
import com.java42.swingy.view.View;

public class GamePlayController {
	GameMap gameMap;
	View view;
	HeroDAO save;
	XPManager xpManager;
	Swingy controller;
	Hero hero;

	public GamePlayController(GameMap gameMap, View view, HeroDAO save, XPManager xpManager, Swingy controller) {
		this.gameMap = gameMap;
		this.view = view;
		this.save = save;
		this.xpManager = xpManager;
		this.controller = controller;
		view.setGameController(this);
	}

	public void playingAction(Hero hero, int level) {
		boolean victory = false;
		int mapSize = gameMap.getMapSize(level);
		int nbOfVilains = gameMap.getNbOfVilains(mapSize);
		List<Vilain> vilains = VilainFactory.getVilains(nbOfVilains, level);

		this.hero = hero;
		hero.resetLostHP();
		gameMap.setInitialMapPosition(hero, mapSize);
		gameMap.setVilainsPosition(vilains, mapSize);
		while (victory == false && hero.getHP() > 0) {
			view.printMap(mapSize, hero, vilains);
			view.promptForDirection();
			if (gameMap.isOutOfMap(level, hero.getX(), hero.getY())) {
				victory = true;
			} else if (gameMap.isVilainPosition(vilains, hero.getY(), hero.getX())) {
				hero = fightAction(hero, vilains);
			}
		}
		view.printEndOfGame(victory);
		if (hero.getHP() <= 0) {
			save.deleteHero(hero);
			hero = null;
		} else {
			hero.resetLostHP();
		}
		save.saveHero(hero);
		controller.menu(hero);
	}

	public void moveHero(int X, int Y) {
		hero.move(X, Y);
	}

	private Hero fightAction(Hero hero, List<Vilain> vilains) {
		try {
			Vilain vilain = gameMap.getVilainFromPosition(vilains, hero.getY(), hero.getX());
			if (view.promptForRun(vilain) && Math.random() > 0.5) {
				view.printRun();
				return hero;
			}

			return fight(hero, vilain, vilains);
		} catch (Exception e) {

		}
		return hero;
	}

	private Hero fight(Hero hero, Vilain vilain, List<Vilain> vilains) {
		Artifact artifact = null;

		view.printFightBegin(hero, vilain);
		currentFight(hero, vilain);
		view.printFightOutCome(hero, vilain);
		if (hero.getHP() > 0) {
			if (Math.random() > 0.5) {
				artifact = ArtifactFactory.getRandomArtifact(vilain.getLevel());
				view.printArtifactDropping(artifact);
				hero.setArtifact(artifact);
			}
			vilains.remove(vilain);
			xpManager.addXP(hero, vilain);
			view.printXPgot(hero, xpManager.getXP(vilain));
		}

		return hero;
	}

	private void currentFight(Hero hero, Vilain vilain) {
		int heroHPlost, vilainHPlost;
		int i = 0;
		while (hero.getHP() > 0 && vilain.getHP() > 0 && i < 10) {
			vilainHPlost = hero.getAttack() * (int) (Math.random() + 0.75)
					- vilain.getDefense() * (int) (Math.random() + 0.4);
			vilain.addLostHP(vilainHPlost);
			heroHPlost = vilain.getAttack() * (int) (Math.random() + 0.5)
					- hero.getDefense() * (int) (Math.random() + 0.75);
			hero.addLostHP(heroHPlost);
			view.printFight(++i, hero, vilain, heroHPlost, vilainHPlost);
		}
	}
}
