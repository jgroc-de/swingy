package com.java42.swingy.view.gui;

import java.util.List;

import com.java42.swingy.lib.map.GameMap;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;

public class GuiGame {
	SwingyFrame frame;

	public GuiGame(SwingyFrame frame) {
		this.frame = frame;
	}

	public void printMap(int level, Hero hero, List<Vilain> vilains) {
		// TODO Auto-generated method stub

	}

	public void printEndOfGame(boolean victory) {
		// TODO Auto-generated method stub

	}

	public void setGameMap(GameMap gameMap) {
		// TODO Auto-generated method stub

	}

	public void printRun() {
		// TODO Auto-generated method stub

	}

	public void printFightBegin(Hero hero, Vilain vilain) {
		// TODO Auto-generated method stub

	}

	public void printFight(int turn, Hero hero, Vilain vilain, int heroHP, int vilainHP) {
		// TODO Auto-generated method stub

	}

	public void printFightOutCome(Hero hero, Vilain vilain) {
		// TODO Auto-generated method stub

	}

	public void printArtifactDropping(Artifact artifact) {
		// TODO Auto-generated method stub

	}

	public void printXPgot(Hero hero, int XP) {
		// TODO Auto-generated method stub

	}

}
