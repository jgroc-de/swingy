package com.java42.swingy.view;

import java.util.Scanner;

import com.java42.swingy.controller.Controller;
import com.java42.swingy.map.Direction;

public class CommandLineGame implements GameView {

	Controller controller;
	Scanner keyboard = new Scanner(System.in);

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void printMap(int mapSize, int heroX, int heroY) {
		int i = 0;
		int j = 0;
		String line;

		while (i++ <= mapSize) {
			if (i != 1) {
				line = "\t|";
			} else {
				line = "\t ";
			}
			j = 0;
			while (j++ < mapSize) {
				if (i - 1 == heroY && j == heroX) {
					line += ":)";
				} else if (i == 1 || i == mapSize + 1) {
					line += "__";
				} else {
					line += "  ";
				}
			}
			if (i != 1) {
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

	public void printEndOfGame(boolean victory) {
		if (victory) {
			System.out.println(" *** Victory !!! ***");
		} else {
			System.out.println("+++ Game Over +++");
		}
	}

}
