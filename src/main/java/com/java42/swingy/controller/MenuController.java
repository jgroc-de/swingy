package com.java42.swingy.controller;

import java.util.List;

import com.java42.swingy.lib.save.HeroDAO;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.hero.HeroFactory;
import com.java42.swingy.model.hero.HeroType;
import com.java42.swingy.view.View;

public class MenuController {
	View view;
	HeroDAO heroDAO;
	Swingy mainController;
	Hero hero;

	public MenuController(View view, HeroDAO save, Swingy controller) {
		this.view = view;
		view.setMenuController(this);
		this.heroDAO = save;
		this.mainController = controller;
	}

	public void menuAction(Hero hero) {
		boolean askAgain = true;

		this.hero = hero;
		while (askAgain) {
			askAgain = view.promptForMenuAction();
		}
	}

	public void startPlaying() {
		view.startPlaying(hero);
		if (hero != null) {
			mainController.play(hero);
		} else {
			menuAction(hero);
		}
	}

	public void quit() {
		view.quit();
		System.exit(0);
	}

	public void createHero(int heroType, String name) {
		int heroID = heroDAO.getNextId();
		HeroType heroClass = HeroType.getType(heroType);

		hero = HeroFactory.createHero(heroClass, heroID, name);
		view.printHero(hero);
		heroDAO.saveHero(hero);
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public void selectHero(int index) {
		List<Hero> heroes = heroDAO.getAllHeroes();
		try {
			setHero(heroes.get(index - 1));
		} catch (Exception e) {
			setHero(null);
		}
	}

	public List<Hero> getAllHeroes() {
		return heroDAO.getAllHeroes();
	}

	public boolean isSetHero() {
		return hero != null;
	}
}
