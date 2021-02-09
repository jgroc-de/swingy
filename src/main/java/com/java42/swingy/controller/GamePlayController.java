package com.java42.swingy.controller;

import java.util.List;

import com.java42.swingy.lib.XPManager.XPManager;
import com.java42.swingy.lib.map.SquareMap;
import com.java42.swingy.lib.save.HeroDAO;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.artifact.ArtifactFactory;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;
import com.java42.swingy.model.vilain.VilainFactory;
import com.java42.swingy.view.View;

public class GamePlayController {
	SquareMap gameMap;
	View view;
	HeroDAO save;
	XPManager xpManager;
	Swingy controller;
	Hero hero;

	public GamePlayController(SquareMap gameMap, View view, HeroDAO save, XPManager xpManager, Swingy controller) {
		this.gameMap = gameMap;
		this.view = view;
		this.save = save;
		this.xpManager = xpManager;
		this.controller = controller;
		view.setGameController(this);
	}

	public void playingAction(Hero hero, int level) {
		boolean victory = false;
		gameMap.setMapSize(level);
		int nbOfVilains = gameMap.getNbOfVilains();
		List<Vilain> vilains = VilainFactory.getVilains(nbOfVilains, level);
		gameMap.setVilains(vilains);

		this.hero = hero;
		hero.resetLostHP();
		gameMap.setInitialMapPosition(hero);
		gameMap.setVilainsPosition();
		view.printMap(hero);
	}

	public void switchPlay() {
		if (gameMap.isOutOfMap(hero.getX(), hero.getY())) {
			hero.resetLostHP();
			save.saveHero(hero);
			view.printVictory(hero);
		} else if (hero.getHP() <= 0) {
			save.deleteHero(hero);
			hero = null;
			view.printGameOver();
		} else if (gameMap.isVilainPosition(hero.getY(), hero.getX())) {
			fightAction(hero, gameMap.getVilains());
		} else {
			view.promptForDirection();
		}
	}

	public void menu(Hero hero) {
		controller.menu(hero);
	}

	public void moveHero(int X, int Y) {
		hero.move(X, Y);
		view.printMap(hero);
	}

	private void fightAction(Hero hero, List<Vilain> vilains) {
		try {
			Vilain vilain = gameMap.getVilainFromPosition(hero.getY(), hero.getX());
			view.promptForRun(hero, vilain);
		} catch (Exception e) {

		}
	}

	public void fight(Hero hero, Vilain vilain) {
		Artifact artifact = null;
		List<Vilain> vilains = gameMap.getVilains();
		String summary;

		summary = currentFight(hero, vilain);
		if (hero.getHP() > 0) {
			if (Math.random() > 0.5) {
				artifact = ArtifactFactory.getRandomArtifact(vilain.getLevel());
				hero.setArtifact(artifact);
			}
			vilains.remove(vilain);
			xpManager.addXP(hero, vilain);
		}
		this.hero = hero;
		view.printFight(summary, hero, vilain, artifact, xpManager.getXP(vilain));
	}

	private String currentFight(Hero hero, Vilain vilain) {
		int heroHPlost, vilainHPlost;
		int turn = 0;
		String summary = "";
		while (hero.getHP() > 0 && vilain.getHP() > 0 && turn < 10) {
			vilainHPlost = hero.getAttack() * (int) (Math.random() + 0.75)
					- vilain.getDefense() * (int) (Math.random() + 0.4);
			vilain.addLostHP(vilainHPlost);
			heroHPlost = vilain.getAttack() * (int) (Math.random() + 0.5)
					- hero.getDefense() * (int) (Math.random() + 0.75);
			hero.addLostHP(heroHPlost);
			if (vilainHPlost < 0) {
				vilainHPlost = 0;
			}
			if (heroHPlost < 0) {
				heroHPlost = 0;
			}
			summary += "\n\t-- Turn " + turn + " -- \n\n";
			summary += "hero lost " + heroHPlost + " HP\n";
			summary += "vilain lost " + vilainHPlost + " HP\n\n";
			summary += hero.getSummary() + "\n" + vilain.getSummary() + "\n";
		}

		return summary;
	}
}
