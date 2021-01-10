package com.java42.swingy.view.commandLine;

import java.util.List;
import java.util.Scanner;

import com.java42.swingy.controller.Swingy;
import com.java42.swingy.lib.map.Direction;
import com.java42.swingy.lib.map.GameMap;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;
import com.java42.swingy.view.GameView;

public class CommandLineGame implements GameView {

	Swingy controller;
	Scanner keyboard = new Scanner(System.in);
	GameMap gameMap;
	boolean isVisible = true;

	@Override
	public void setController(Swingy controller) {
		this.controller = controller;
	}

	@Override
	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	@Override
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

	@Override
	public Direction promptForDirection() {
		int userInput;
		System.out.println("SELECT A DIRECTION:");
		for (Direction direction : Direction.values()) {
			System.out.println("\t[" + direction.getValue() + "]: " + direction.getLabel());
		}
		userInput = keyboard.nextInt();
		for (Direction direction : Direction.values()) {
			if (direction.getValue() == userInput) {
				return direction;
			}
		}

		return promptForDirection();
	}

	@Override
	public void printEndOfGame(boolean victory) {
		if (victory) {
			System.out.println("\n\t*** Victory !!! ***");
		} else {
			System.out.println("\n\t+++ Game Over +++");
		}
	}

	@Override
	public boolean promptForRun(Vilain vilain) {
		int choice;

		System.out.println("You are facing a vilain: " + vilain.getSummary());
		System.out.println("CHOOSE RUN OR FIGHT\n\t[1] RUN [2] FIGHT");
		choice = keyboard.nextInt();
		if (choice == 1) {
			return true;
		}
		return false;
	}

	@Override
	public void printRun() {
		System.out.println("\n\t--- RUN ---\n");
	}

	@Override
	public void printFightBegin(Hero hero, Vilain vilain) {
		System.out.println("\n\txxx FIGHT xxx\n");
	}

	@Override
	public void printFightOutCome(Hero hero, Vilain vilain) {
		if (hero.getHP() > 0) {
			System.out.println("\n\t*** YOU WON !! ***\n");
		} else {
			System.out.println("\n\t+++ YOU DIED !! +++\n");
			System.out.println(vilain.getSummary());
		}
	}

	@Override
	public void printFight(int turn, Hero hero, Vilain vilain, int heroLostHP, int vilainLostHP) {
		if (vilainLostHP < 0) {
			vilainLostHP = 0;
		}
		if (heroLostHP < 0) {
			heroLostHP = 0;
		}
		System.out.println("\n\tTurn" + turn + "\n");
		System.out.println("hero lost " + heroLostHP + " HP");
		System.out.println("vilain lost " + vilainLostHP + " HP");
		System.out.println();
		System.out.println(hero.getSummary());
		System.out.println(vilain.getSummary());
	}

	@Override
	public void printArtifactDropping(Artifact artifact) {
		System.out.println("Vilain drop an artifact!\n\t" + artifact.getDescription());
	}

	@Override
	public void printXPgot(Hero hero, int XP) {
		System.out.println("You got " + XP + " XP");
		System.out.println(hero.getSummary());
	}

}
