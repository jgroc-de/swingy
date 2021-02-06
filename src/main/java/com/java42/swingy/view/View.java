package com.java42.swingy.view;

import java.util.List;

import com.java42.swingy.controller.GamePlayController;
import com.java42.swingy.controller.MenuController;
import com.java42.swingy.lib.map.SquareMap;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;

public interface View {
	public boolean promptForRun(Vilain vilain);

	public void promptForDirection();

	public void printMap(int level, Hero hero, List<Vilain> vilains);

	public void printVictory(Hero hero);

	public void printGameOver();

	public void setGameMap(SquareMap gameMap);

	public void printRun();

	public void printFightBegin(Hero hero, Vilain vilain);

	public void printFight(int turn, Hero hero, Vilain vilain, int heroHP, int vilainHP);

	public void printFightOutCome(Hero hero, Vilain vilain);

	public void printArtifactDropping(Artifact artifact);

	public void printXPgot(Hero hero, int XP);

	public boolean promptForMenuAction();

	public void splashScreen();

	public void quit();

	public void printHero(Hero hero);

	public void startPlaying(Hero hero);

	public void setMenuController(MenuController controller);

	public void setGameController(GamePlayController controller);

}
