package com.java42.swingy.view;

import java.util.List;

import com.java42.swingy.lib.map.Direction;
import com.java42.swingy.lib.map.GameMap;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;

public interface GameView extends View {
	public void printMap(int level, Hero hero, List<Vilain> vilains);

	public Direction promptForDirection();

	public void printEndOfGame(boolean victory);

	public void setGameMap(GameMap gameMap);

	public boolean promptForRun(Vilain vilain);

	public void printRun();

	public void printFightBegin(Hero hero, Vilain vilain);

	public void printFight(int turn, Hero hero, Vilain vilain, int heroHP, int vilainHP);

	public void printFightOutCome(Hero hero, Vilain vilain);

	public void printArtifactDropping(Artifact artifact);

	public void printXPgot(Hero hero, int XP);
}
