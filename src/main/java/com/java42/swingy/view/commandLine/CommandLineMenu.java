package com.java42.swingy.view.commandLine;

import java.util.List;
import java.util.Scanner;

import com.java42.swingy.controller.MenuItem;
import com.java42.swingy.controller.Swingy;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.hero.HeroType;
import com.java42.swingy.view.MenuView;

public class CommandLineMenu implements MenuView {
	Swingy controller;
	Scanner keyboard = new Scanner(System.in);

	private void println(String lineToPrint) {
		System.out.println(lineToPrint + "\n");
	}

	@Override
	public void splashScreen() {
		String line = "\t\t**************\n" + "\t\t*** Swingy ***\n" + "\t\t**************\n\n";
		println(line);
	}

	@Override
	public void quit() {
		String line = "\t\t***************\n" + "\t\t*** The End ***\n" + "\t\t***************\n\n";
		println(line);
	}

	@Override
	public void setController(Swingy controller) {
		this.controller = controller;
	}

	@Override
	public MenuItem promptForMenuAction(boolean heroIsSet) {
		int itemNumber = -1;
		String line;

		line = "CHOOSE A NUMBER:\n";
		for (MenuItem menuItem : MenuItem.values()) {
			line += "\t[" + menuItem.getValue() + "]: " + menuItem.getLabel(heroIsSet) + "\n";
		}
		while (MenuItem.isValidItem(itemNumber) == false) {
			println(line);
			itemNumber = keyboard.nextInt();
		}

		return MenuItem.getItem(itemNumber);
	}

	@Override
	public int promptForHeroType() {
		String line;

		line = "CHOOSE A CLASS FOR YOUR HERO:\n";
		for (HeroType type : HeroType.values()) {
			line += "\t[" + type.getValue() + "] " + type + "\n";
		}
		println(line);

		return keyboard.nextInt();
	}

	@Override
	public String promptForHeroName() {
		println("ENTER A NAME");
		return keyboard.next();
	}

	@Override
	public void printHero(Hero hero) {
		println(hero.getFullDescription());
	}

	@Override
	public void startPlaying(Hero hero) {
		if (hero != null) {
			println("GL&HF WITH THIS HERO\n");
			printHero(hero);
		} else {
			println("CHOOSE OR CREATE A HERO FIRST\n");
		}
	}

	@Override
	public int promptForHeroSelection(List<Hero> heroes) {
		int heroIndex = 1;
		String line;

		line = "CHOOSE YOUR HERO\n";
		for (Hero hero : heroes) {
			line += "[" + heroIndex++ + "]: " + hero.getSummary() + "\n";
		}
		println(line);

		return keyboard.nextInt();

	}

	@Override
	public void printHeroListIsEmpty() {
		println("Hero list is empty for now\n");
	}
}
