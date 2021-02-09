package com.java42.swingy.view.cli;

import com.java42.swingy.controller.GamePlayController;
import com.java42.swingy.lib.IO.Misc;
import com.java42.swingy.lib.map.Direction;
import com.java42.swingy.lib.map.SquareMap;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;
import com.java42.swingy.view.GameMessages;

public class CliGame {

	public enum fightChoice {
		RUN(1), FIGHT(2);

		int value;

		fightChoice(int i) {
			this.value = i;
		}

		public int getValue() {
			return value;
		}
	};

	Misc IOManager = new Misc();
	GamePlayController controller;
	SquareMap gameMap;
	boolean isVisible = true;

	public void setGameMap(SquareMap gameMap) {
		this.gameMap = gameMap;
	}

	public void promptForRun(Hero hero, Vilain vilain) {
		int choice;
		boolean canRun = Math.random() > 0.5;

		System.out.println(GameMessages.FACINGVILAIN + vilain.getSummary());
		System.out.println("CHOOSE RUN OR FIGHT\n\t[" + fightChoice.RUN.getValue() + "] " + GameMessages.RUN + " ["
				+ fightChoice.FIGHT.getValue() + "] " + GameMessages.FIGHT);
		choice = IOManager.getNextNumber();
		if (choice == fightChoice.RUN.getValue() && canRun) {
			System.out.println("\n\t--- RUN ---\n");
			controller.switchPlay();
		} else if (choice == fightChoice.FIGHT.getValue() || canRun == false) {
			controller.fight(hero, vilain);
		} else {
			promptForRun(hero, vilain);
		}
	}

	public void promptForDirection() {
		int userInput;
		Direction direction = Direction.NORTH;
		boolean notValid = true;

		while (notValid) {
			System.out.println(GameMessages.DIRECTION.toString());
			for (Direction tmpDirection : Direction.values()) {
				System.out.println("\t[" + tmpDirection.getValue() + "]: " + tmpDirection.getLabel());
			}
			userInput = IOManager.getNextNumber();
			for (Direction tmpDirection : Direction.values()) {
				if (tmpDirection.getValue() == userInput) {
					direction = tmpDirection;
					notValid = false;
					break;
				}
			}
		}

		controller.moveHero(direction.getX(), direction.getY());
	}

	public void printMap(Hero hero) {
		int mapSize = gameMap.getMapSize();
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
				} else if (gameMap.isVilainPosition(modifiedY, x)) {
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
		controller.switchPlay();

	}

	public void victory(Hero hero) {
		System.out.println("\n\t*** Victory !!! ***");
		controller.menu(hero);
	}

	public void gameOver() {
		System.out.println("\n\t+++ Game Over +++");
		controller.menu(null);
	}

	public void printFight(String summary, Hero hero, Vilain vilain, Artifact artifact, int XPWon) {
		System.out.println("\n\txxx FIGHT xxx\n");
		IOManager.println(summary);
		if (hero.getHP() > 0) {
			System.out.println("\n\t*** YOU WON !! ***\n");
			if (artifact != null) {
				System.out.println("Vilain drop an artifact!\n\t" + artifact.getDescription());
			}
			System.out.println("You got " + XPWon + " XP");
			System.out.println(hero.getSummary());
			printMap(hero);
		} else {
			System.out.println("\n\t+++ YOU DIED !! +++\n");
			System.out.println(vilain.getSummary());
			controller.switchPlay();
		}
	}

	public void setGameController(GamePlayController controller) {
		this.controller = controller;
	}

}
