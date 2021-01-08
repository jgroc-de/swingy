package com.java42.swingy.view;

import java.util.List;
import java.util.Scanner;

import com.java42.swingy.controller.Controller;
import com.java42.swingy.heroTypes.HeroType;
import com.java42.swingy.model.Hero;

public class CommandLineMenu implements MenuView {
	Controller controller;
	Scanner keyboard = new Scanner(System.in);

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public MenuItem promptForMenuAction(boolean heroIsSet) {
		int itemNumber = -1;
		while (MenuItem.isValidItem(itemNumber) == false) {
			System.out.println("CHOOSE A NUMBER:");
			for (MenuItem menuItem : MenuItem.values()) {
				System.out.println("\t[" + menuItem.getValue() + "]: " + menuItem.getLabel(heroIsSet));
			}
			itemNumber = keyboard.nextInt();
		}

		return MenuItem.getItem(itemNumber);
	}

	public int promptForHeroType() {
		System.out.println("CHOOSE A CLASS FOR YOUR HERO:");
		for (HeroType type : HeroType.values()) {
			System.out.println("\t[" + type.getValue() + "] " + type);
		}
		return keyboard.nextInt();
	}

	public String promptForHeroName() {
		System.out.println("ENTER A NAME");
		return keyboard.next();
	}

	public void printHero(Hero hero) {
		System.out.println(hero);
	}

	public void startPlaying(Hero hero) {
		if (hero != null) {
			System.out.println("GL&HF WITH THIS HERO\n");
			printHero(hero);
		} else {
			System.out.println("CHOOSE OR CREATE A HERO FIRST");
		}
	}

	public void quit() {
		System.out.println("\n *** THE END ***");
	}

	@Override
	public int promptForHeroSelection(List<Hero> heroes) {
		int i = 1;
		System.out.println("CHOOSE YOUR HERO");
		for (Hero hero : heroes) {
			System.out.println("[" + i++ + "]: " + hero.getSummary());
		}

		return keyboard.nextInt();

	}

	@Override
	public void printHeroListIsEmpty() {
		System.out.println("Hero list is empty for now");

	}
}
