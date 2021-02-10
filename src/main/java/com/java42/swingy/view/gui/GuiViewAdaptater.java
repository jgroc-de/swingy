package com.java42.swingy.view.gui;

import com.java42.swingy.controller.GamePlayController;
import com.java42.swingy.controller.MenuController;
import com.java42.swingy.lib.map.SquareMap;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;
import com.java42.swingy.view.View;
import com.java42.swingy.view.gui.gameBoard.GuiGame;
import com.java42.swingy.view.gui.menu.GuiMenu;

public class GuiViewAdaptater implements View {
	GuiGame game;
	GuiMenu menu;

	public GuiViewAdaptater() {
		SwingyFrame frame = new SwingyFrame();
		game = new GuiGame(frame);
		menu = new GuiMenu(frame);
	}

	@Override
	public void promptForRun(Hero hero, Vilain vilain) {
		// TODO Auto-generated method stub
	}

	@Override
	public void promptForDirection() {
		// TODO Auto-generated method stub
	}

	@Override
	public void printMap(Hero hero) {
		game.printMap(hero);
	}

	@Override
	public void printVictory(Hero hero) {
		// TODO Auto-generated method stub
	}

	@Override
	public void printGameOver() {
	}

	@Override
	public void setGameMap(SquareMap gameMap) {
		game.setGameMap(gameMap);
	}

	@Override
	public void printFight(String summary, Hero hero, Vilain vilain, Artifact artifact, int XPWon) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean promptForMenuAction() {
		return menu.menuActions();
	}

	@Override
	public void splashScreen() {
		// DO nothing
	}

	@Override
	public void quit() {
		menu.quit();
	}

	@Override
	public void printHero(Hero hero) {
		menu.printHero(hero);
	}

	@Override
	public void startPlaying(Hero hero) {
		menu.startPlaying(hero);
	}

	@Override
	public void setMenuController(MenuController controller) {
		menu.setMenuController(controller);
	}

	@Override
	public void setGameController(GamePlayController controller) {
		game.setGameController(controller);
	}
}
