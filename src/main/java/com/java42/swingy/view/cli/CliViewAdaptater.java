package com.java42.swingy.view.cli;

import com.java42.swingy.controller.GamePlayController;
import com.java42.swingy.controller.MenuController;
import com.java42.swingy.lib.map.SquareMap;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;
import com.java42.swingy.view.View;

public class CliViewAdaptater implements View {
	CliMenu menuView;
	CliGame gameView;

	public CliViewAdaptater() {
		menuView = new CliMenu();
		gameView = new CliGame();
	}

	@Override
	public void setMenuController(MenuController controller) {
		menuView.setMenuController(controller);
	}

	@Override
	public void promptForRun(Hero hero, Vilain vilain) {
		gameView.promptForRun(hero, vilain);
	}

	@Override
	public void promptForDirection() {
		gameView.promptForDirection();
	}

	@Override
	public void printMap(Hero hero) {
		gameView.printMap(hero);
	}

	@Override
	public void printVictory(Hero hero) {
		gameView.victory(hero);
	}

	@Override
	public void printGameOver() {
		gameView.gameOver();
	}

	@Override
	public void setGameMap(SquareMap gameMap) {
		gameView.setGameMap(gameMap);
	}

	@Override
	public void printFight(String summary, Hero hero, Vilain vilain, Artifact artifact, int XPWon) {
		gameView.printFight(summary, hero, vilain, artifact, XPWon);
	}

	@Override
	public boolean promptForMenuAction() {
		return menuView.promptForMenuAction();
	}

	@Override
	public void splashScreen() {
		menuView.splashScreen();
	}

	@Override
	public void quit() {
		menuView.quit();
	}

	@Override
	public void printHero(Hero hero) {
		menuView.printHero(hero);
	}

	@Override
	public void startPlaying(Hero hero) {
		menuView.startPlaying(hero);
	}

	public void printHeroListIsEmpty() {
		menuView.printHeroListIsEmpty();
	}

	@Override
	public void setGameController(GamePlayController controller) {
		gameView.setGameController(controller);
	}
}
