package com.java42.swingy.view.cli;

import java.util.List;
import java.util.Scanner;

import com.java42.swingy.controller.MenuController;
import com.java42.swingy.controller.MenuItem;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.hero.HeroType;
import com.java42.swingy.view.GameMessages;

public class CliMenu {
	String deco = "\n\t\t**************\n";
	Scanner keyboard = new Scanner(System.in);
	MenuController controller;

	public void setMenuController(MenuController controller) {
		this.controller = controller;
	}

	private void println(String lineToPrint) {
		System.out.println(lineToPrint + "\n");
	}

	private String decorate(String line) {
		return deco + "\t\t*** " + line + " ***" + deco;
	}

	public boolean promptForMenuAction() {
		boolean heroIsSet = controller.isSetHero();
		List<Hero> heroes = controller.getAllHeroes();
		MenuItem choice;

		choice = getMenuItem(heroIsSet, heroes);
		switch (choice) {
		case HERO_CREATION:
			promptForNewHero();
			break;
		case HERO_SELECTION:
			promptForHeroSelection(heroes);
			break;
		case PLAY:
			controller.startPlaying();
			break;
		case QUIT:
			controller.quit();
		}

		return true;
	}

	private MenuItem getMenuItem(boolean heroIsSet, List<Hero> heroes) {
		int itemNumber = -1;
		String line;

		line = GameMessages.NUMBER + "\n";
		for (MenuItem menuItem : MenuItem.values()) {
			if (menuItem.canDoThis(heroIsSet, heroes.isEmpty())) {
				line += "\t[" + menuItem.getValue() + "]: " + menuItem.getLabel() + "\n";
			}
		}
		while (MenuItem.isValidItem(itemNumber) == false) {
			println(line);
			itemNumber = keyboard.nextInt();
		}

		return MenuItem.getItem(itemNumber);
	}

	private void promptForNewHero() {
		int heroType = promptForHeroType();
		String name = promptForHeroName();

		controller.createHero(heroType, name);
	}

	private int promptForHeroType() {
		String line;
		int choice;

		line = GameMessages.CLASS + "\n";
		for (HeroType type : HeroType.values()) {
			line += "\t[" + type.getValue() + "] " + type + "\n";
		}
		do {
			println(line);
			choice = keyboard.nextInt();
		} while (HeroType.isType(choice) == false);

		return choice;
	}

	private String promptForHeroName() {
		println(GameMessages.NAME.toString());
		// la récupération précédente étant un nextInt(), il faut vider le buffer
		keyboard.nextLine();
		return keyboard.nextLine();
	}

	private void promptForHeroSelection(List<Hero> heroes) {
		int heroIndex = 1;
		String line;

		line = GameMessages.HERO + "\n";
		for (Hero hero : heroes) {
			line += "[" + heroIndex++ + "]: " + hero.getSummary() + "\n";
		}
		println(line);

		heroIndex = keyboard.nextInt();
		controller.selectHero(heroIndex);
	}

	public void splashScreen() {
		println(decorate(GameMessages.INTRO.toString()));
	}

	public void quit() {
		println(decorate(GameMessages.ENDING.toString()));
	}

	public void printHero(Hero hero) {
		println(hero.getFullDescription());
	}

	public void startPlaying(Hero hero) {
		if (hero != null) {
			println(GameMessages.GLHF + "\n");
			printHero(hero);
		} else {
			println(GameMessages.CHOOSE + "\n");
		}
	}

	public void printHeroListIsEmpty() {
		println(GameMessages.EMPTYLIST + "\n");
	}
}
