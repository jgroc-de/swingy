package com.java42.swingy.view.gui.menu;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import com.java42.swingy.controller.MenuController;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.view.GameMessages;
import com.java42.swingy.view.gui.SwingyFrame;
import com.java42.swingy.view.gui.menu.panels.HeroCreationPanel;
import com.java42.swingy.view.gui.menu.panels.MainMenuPanel;
import com.java42.swingy.view.gui.menu.panels.SelectionListPanel;

public class GuiMenu {

	SwingyFrame frame;
	MenuController controller;

	public GuiMenu(SwingyFrame frame) {
		this.frame = frame;
	}

	public void setMenuController(MenuController controller) {
		this.controller = controller;
	}

	public boolean menuActions() {
		boolean heroIsSet = controller.isSetHero();
		List<Hero> heroes = controller.getAllHeroes();
		MainMenuPanel menu = new MainMenuPanel(this, heroIsSet, heroes.isEmpty());

		frame.setContentPane(menu);
		frame.setVisible(true);
		return false;
	}

	public void promptForHeroSelection() {
		List<Hero> heroes = controller.getAllHeroes();
		SelectionListPanel list = new SelectionListPanel(this, heroes);
		JScrollPane areaScrollPane = new JScrollPane(list);
		areaScrollPane.setAutoscrolls(false);
		frame.setContentPane(areaScrollPane);
		frame.setVisible(true);
	}

	public void promptForHeroCreation() {
		List<Hero> heroes = controller.getAllHeroes();
		HeroCreationPanel panel = new HeroCreationPanel(this, heroes);
		panel.setOpaque(false);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}

	public void createHero(int heroType, String name) {
		controller.createHero(heroType, name);
		menuActions();
	}

	public void setHero(int index) {
		controller.selectHero(index - 1);
		menuActions();
	}

	public void printHero(Hero hero) {
	}

	public void play() {
		controller.startPlaying();
	}

	public void startPlaying(Hero hero) {
	}

	public void exit() {
		controller.quit();
	}

	public void quit() {
	}

	public void printHeroListIsEmpty() {
		JOptionPane.showMessageDialog(frame, GameMessages.EMPTYLIST, "Information", JOptionPane.INFORMATION_MESSAGE);
	}

}
