package com.java42.swingy.view.cli;

import com.java42.swingy.controller.GamePlayController;
import com.java42.swingy.lib.IO.Misc;
import com.java42.swingy.lib.map.Direction;
import com.java42.swingy.model.vilain.Vilain;
import com.java42.swingy.view.GameMessages;

public class CliGamePrompt {
	Misc IOManager = new Misc();
	GamePlayController controller;

	public void setGameController(GamePlayController controller) {
		this.controller = controller;
	}

	public boolean promptForRun(Vilain vilain) {
		int choice;

		System.out.println(GameMessages.FACINGVILAIN + vilain.getSummary());
		System.out.println("CHOOSE RUN OR FIGHT\n\t[1] " + GameMessages.RUN + " [2] " + GameMessages.FIGHT);
		choice = IOManager.getNextNumber();
		if (choice == 1) {
			return true;
		} else if (choice == 2) {
			return false;
		}
		return promptForRun(vilain);
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

}
