package com.java42.swingy.view.gui;

import java.util.List;

import com.java42.swingy.controller.Swingy;
import com.java42.swingy.lib.map.Direction;
import com.java42.swingy.lib.map.GameMap;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;
import com.java42.swingy.view.GameView;

public class GuiGame implements GameView {

	@Override
	public void setController(Swingy controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printMap(int level, Hero hero, List<Vilain> vilains) {
		// TODO Auto-generated method stub

	}

	@Override
	public Direction promptForDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printEndOfGame(boolean victory) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setGameMap(GameMap gameMap) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean promptForRun(Vilain vilain) {
		// TODO Auto-generated method stub
		return false;
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

}
