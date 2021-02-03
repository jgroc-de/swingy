package com.java42.swingy.view.cli;

import java.util.List;

import com.java42.swingy.controller.MenuController;
import com.java42.swingy.controller.MenuItem;
import com.java42.swingy.lib.IO.Misc;
import com.java42.swingy.model.LivingCreature;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.hero.HeroType;
import com.java42.swingy.view.GameMessages;

public class CliMenu {
	String deco = "\n\t\t**************\n";
	Misc IOManager = new Misc();
	MenuController controller;

	public void setMenuController(MenuController controller) {
		this.controller = controller;
	}

	private String decorate(String line) {
		return deco + "\t\t*** " + line + " ***" + deco;
	}

	public boolean promptForMenuAction() {
		boolean heroIsSet = controller.isSetHero();
		List<Hero> heroes = controller.getAllHeroes();
		MenuItem choice;

		choice = promptForMenuItem(heroIsSet, heroes);
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

	private MenuItem promptForMenuItem(boolean heroIsSet, List<Hero> heroes) {
		int itemNumber;
		String line;

		line = GameMessages.NUMBER + "\n";
		for (MenuItem menuItem : MenuItem.values()) {
			if (menuItem.canDoThis(heroIsSet, heroes.isEmpty())) {
				line += "\t[" + menuItem.getValue() + "]: " + menuItem.getLabel() + "\n";
			}
		}
		do {
			IOManager.println(line);
			itemNumber = IOManager.getNextNumber();
		} while (MenuItem.isValidItem(itemNumber) == false);

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
			IOManager.println(line);
			choice = IOManager.getNextNumber();
		} while (HeroType.isType(choice) == false);

		return choice;
	}

	private String promptForHeroName() {
		String name;

		// la récupération précédente étant un nextInt(), il faut vider le buffer
		IOManager.nextLine();
		do {
			System.out.println(GameMessages.NAME.toString());
			IOManager.println("(only letters and digit, no more than 13 characters)");
			name = IOManager.nextLine();
		} while (LivingCreature.isValidName(name) == false);

		return name;
	}

	private void promptForHeroSelection(List<Hero> heroes) {
		int heroIndex = 1;
		String line;

		line = GameMessages.HERO + "\n";
		for (Hero hero : heroes) {
			line += "[" + heroIndex++ + "]: " + hero.getSummary() + "\n";
		}
		do {
			IOManager.println(line);
			heroIndex = IOManager.getNextNumber();
		} while (heroIndex < 0 || heroIndex > heroes.size());
		controller.selectHero(heroIndex);
	}

	public void splashScreen() {
		IOManager.println(decorate(GameMessages.INTRO.toString()));
	}

	public void quit() {
		IOManager.println(decorate(GameMessages.ENDING.toString()));
	}

	public void printHero(Hero hero) {
		IOManager.println(hero.getFullDescription());
	}

	public void startPlaying(Hero hero) {
		if (hero != null) {
			IOManager.println(GameMessages.GLHF + "\n");
			printHero(hero);
		} else {
			IOManager.println(GameMessages.CHOOSE + "\n");
		}
	}

	public void printHeroListIsEmpty() {
		IOManager.println(GameMessages.EMPTYLIST + "\n");
	}
}
