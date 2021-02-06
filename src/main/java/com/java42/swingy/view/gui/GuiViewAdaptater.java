package com.java42.swingy.view.gui;

import java.util.List;

import com.java42.swingy.controller.GamePlayController;
import com.java42.swingy.controller.MenuController;
import com.java42.swingy.lib.map.SquareMap;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;
import com.java42.swingy.view.View;
import com.java42.swingy.view.gui.gameboard.GuiGame;
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
	public boolean promptForRun(Vilain vilain) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void promptForDirection() {
		// TODO Auto-generated method stub
	}

	@Override
	public void printMap(int level, Hero hero, List<Vilain> vilains) {
		game.printMap(level, hero, vilains);

	}

	@Override
	public void printVictory(Hero hero) {
		// TODO Auto-generated method stub
	}

	public void printGameOver() {
	}

	@Override
	public void setGameMap(SquareMap gameMap) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printRun() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printFightBegin(Hero hero, Vilain vilain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printFight(int turn, Hero hero, Vilain vilain, int heroHP, int vilainHP) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printFightOutCome(Hero hero, Vilain vilain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printArtifactDropping(Artifact artifact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printXPgot(Hero hero, int XP) {
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

	public void setGameController(GamePlayController controller) {
		game.setGameController(controller);
	}
}
