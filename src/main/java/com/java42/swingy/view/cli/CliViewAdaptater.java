package com.java42.swingy.view.cli;

import java.util.List;

import com.java42.swingy.controller.GamePlayController;
import com.java42.swingy.controller.MenuController;
import com.java42.swingy.lib.map.GameMap;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;
import com.java42.swingy.view.View;

public class CliViewAdaptater implements View {
	CliMenu menuView;
	CliGame gameView;
	CliGamePrompt gamePrompt;

	public CliViewAdaptater() {
		menuView = new CliMenu();
		gameView = new CliGame();
		gamePrompt = new CliGamePrompt();
	}

	public void setMenuController(MenuController controller) {
		menuView.setMenuController(controller);
	}

	public boolean promptForRun(Vilain vilain) {
		return gamePrompt.promptForRun(vilain);
	}

	public void promptForDirection() {
		gamePrompt.promptForDirection();
	}

	public void printMap(int level, Hero hero, List<Vilain> vilains) {
		gameView.printMap(level, hero, vilains);
	}

	public void printEndOfGame(boolean victory) {
		gameView.printEndOfGame(victory);
	}

	public void setGameMap(GameMap gameMap) {
		gameView.setGameMap(gameMap);
	}

	public void printRun() {
		gameView.printRun();
	}

	public void printFightBegin(Hero hero, Vilain vilain) {
		gameView.printFightBegin(hero, vilain);
	}

	public void printFight(int turn, Hero hero, Vilain vilain, int heroHP, int vilainHP) {
		gameView.printFight(turn, hero, vilain, heroHP, vilainHP);
	}

	public void printFightOutCome(Hero hero, Vilain vilain) {
		gameView.printFightOutCome(hero, vilain);
	}

	public void printArtifactDropping(Artifact artifact) {
		gameView.printArtifactDropping(artifact);
	}

	public void printXPgot(Hero hero, int XP) {
		gameView.printXPgot(hero, XP);
	}

	@Override
	public boolean promptForMenuAction() {
		return menuView.promptForMenuAction();
	}

	public void splashScreen() {
		menuView.splashScreen();
	}

	public void quit() {
		menuView.quit();
	}

	public void printHero(Hero hero) {
		menuView.printHero(hero);
	}

	public void startPlaying(Hero hero) {
		menuView.startPlaying(hero);
	}

	public void printHeroListIsEmpty() {
		menuView.printHeroListIsEmpty();
	}

	public void setGameController(GamePlayController controller) {
		gamePrompt.setGameController(controller);
	}
}
