package com.java42.swingy.controller;

import java.util.List;

import com.java42.swingy.controller.Swingy.GameState;
import com.java42.swingy.lib.save.Save;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.hero.HeroFactory;
import com.java42.swingy.model.hero.HeroType;
import com.java42.swingy.view.MenuView;

public class MenuController {
	MenuView menuView;
	Save save;
	Swingy controller;

	public MenuController(MenuView menuView, Save save, Swingy controller) {
		this.menuView = menuView;
		this.save = save;
		this.controller = controller;
	}

	public GameState menuAction(Hero hero) {
		boolean heroIsSet;
		MenuItem choice;

		while (true) {
			heroIsSet = hero != null;
			choice = menuView.promptForMenuAction(heroIsSet);
			switch (choice) {
			case HERO_CREATION:
				hero = heroCreation();
				save.saveHero(hero);
				break;
			case HERO_SELECTION:
				hero = heroSelection();
				break;
			case PLAY:
				menuView.startPlaying(hero);
				if (hero != null) {
					return GameState.PLAYING;
				}
				break;
			case QUIT:
				return GameState.END;
			}
			controller.setHero(hero);
		}
	}

	private Hero heroCreation() {
		Hero createdHero;
		int heroType = menuView.promptForHeroType();
		int heroID = save.getNextId();
		String name = menuView.promptForHeroName();
		HeroType heroClass = HeroType.getType(heroType);

		createdHero = HeroFactory.createHero(heroClass, heroID, name);
		menuView.printHero(createdHero);

		return createdHero;
	}

	private Hero heroSelection() {
		List<Hero> heroes = save.getAllHeroes();
		int heroIndex;

		if (heroes.isEmpty()) {
			menuView.printHeroListIsEmpty();
			return null;
		}
		heroIndex = menuView.promptForHeroSelection(heroes) - 1;
		try {
			return heroes.get(heroIndex);
		} catch (Exception e) {
			return null;
		}
	}
}
