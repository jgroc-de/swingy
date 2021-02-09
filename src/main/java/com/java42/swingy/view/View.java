package com.java42.swingy.view;

import com.java42.swingy.controller.GamePlayController;
import com.java42.swingy.controller.MenuController;
import com.java42.swingy.lib.map.SquareMap;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;

public interface View {
	public void promptForRun(Hero hero, Vilain vilain);

	public void promptForDirection();

	public void printMap(Hero hero);

	public void printVictory(Hero hero);

	public void printGameOver();

	public void setGameMap(SquareMap gameMap);

	public void printFight(String summary, Hero hero, Vilain vilain, Artifact artifact, int XPWon);

	public boolean promptForMenuAction();

	public void splashScreen();

	public void quit();

	public void printHero(Hero hero);

	public void startPlaying(Hero hero);

	public void setMenuController(MenuController controller);

	public void setGameController(GamePlayController controller);

}
