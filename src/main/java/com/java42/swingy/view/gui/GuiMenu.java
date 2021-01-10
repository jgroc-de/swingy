package com.java42.swingy.view.gui;

import java.util.List;

import com.java42.swingy.controller.MenuItem;
import com.java42.swingy.controller.Swingy;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.view.MenuView;

public class GuiMenu implements MenuView {

	@Override
	public void splashScreen() {

	}

	@Override
	public void setController(Swingy controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public MenuItem promptForMenuAction(boolean heroIsSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int promptForHeroType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String promptForHeroName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printHero(Hero hero) {
		// TODO Auto-generated method stub

	}

	@Override
	public void startPlaying(Hero hero) {
		// TODO Auto-generated method stub

	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub

	}

	@Override
	public int promptForHeroSelection(List<Hero> heroes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printHeroListIsEmpty() {
		// TODO Auto-generated method stub

	}

}
