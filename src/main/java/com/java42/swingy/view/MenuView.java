package com.java42.swingy.view;

import java.util.List;

import com.java42.swingy.controller.MenuItem;
import com.java42.swingy.model.hero.Hero;

public interface MenuView extends View {

	public void splashScreen();

	public MenuItem promptForMenuAction(boolean heroIsSet);

	public int promptForHeroType();

	public String promptForHeroName();

	public void printHero(Hero hero);

	public void startPlaying(Hero hero);

	public void quit();

	public int promptForHeroSelection(List<Hero> heroes);

	public void printHeroListIsEmpty();
}
