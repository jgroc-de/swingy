package com.java42.swingy.view.cli;

import java.util.List;

import com.java42.swingy.controller.GamePlayController;
import com.java42.swingy.lib.map.GameMap;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;

public class CliGame {

	GamePlayController controller;
	GameMap gameMap;
	boolean isVisible = true;

	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	public void printMap(int mapSize, Hero hero, List<Vilain> vilains) {
		int y = 0;
		int x = 0;
		int modifiedY;
		String line;

		while (y++ <= mapSize) {
			if (y != 1) {
				line = "\t|";
			} else {
				line = "\t ";
			}
			x = 0;
			modifiedY = y - 1;
			while (x++ < mapSize) {
				if (gameMap.isLivingPosition(hero, modifiedY, x)) {
					line += ":)";
				} else if (gameMap.isVilainPosition(vilains, modifiedY, x)) {
					if (isVisible) {
						line += "><";
					} else {
						line += "  ";
					}
				} else if (y == 1 || y == mapSize + 1) {
					line += "__";
				} else {
					line += "  ";
				}
			}
			if (y != 1) {
				line = line + "|";
			}
			System.out.println(line);
		}

	}

	public void printEndOfGame(boolean victory) {
		if (victory) {
			System.out.println("\n\t*** Victory !!! ***");
		} else {
			System.out.println("\n\t+++ Game Over +++");
		}
	}

	public void printRun() {
		System.out.println("\n\t--- RUN ---\n");
	}

	public void printFightBegin(Hero hero, Vilain vilain) {
		System.out.println("\n\txxx FIGHT xxx\n");
	}

	public void printFightOutCome(Hero hero, Vilain vilain) {
		if (hero.getHP() > 0) {
			System.out.println("\n\t*** YOU WON !! ***\n");
		} else {
			System.out.println("\n\t+++ YOU DIED !! +++\n");
			System.out.println(vilain.getSummary());
		}
	}

	public void printFight(int turn, Hero hero, Vilain vilain, int heroLostHP, int vilainLostHP) {
		if (vilainLostHP < 0) {
			vilainLostHP = 0;
		}
		if (heroLostHP < 0) {
			heroLostHP = 0;
		}
		System.out.println("\n\t-- Turn " + turn + " -- \n");
		System.out.println("hero lost " + heroLostHP + " HP");
		System.out.println("vilain lost " + vilainLostHP + " HP");
		System.out.println();
		System.out.println(hero.getSummary());
		System.out.println(vilain.getSummary());
	}

	public void printArtifactDropping(Artifact artifact) {
		System.out.println("Vilain drop an artifact!\n\t" + artifact.getDescription());
	}

	public void printXPgot(Hero hero, int XP) {
		System.out.println("You got " + XP + " XP");
		System.out.println(hero.getSummary());
	}

	public void setGameController(GamePlayController controller) {
		this.controller = controller;

	}

}
