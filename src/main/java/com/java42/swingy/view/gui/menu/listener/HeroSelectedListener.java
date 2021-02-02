package com.java42.swingy.view.gui.menu.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.java42.swingy.view.gui.menu.GuiMenu;

public class HeroSelectedListener implements ActionListener {
	GuiMenu menu;
	int heroIndex;

	public HeroSelectedListener(GuiMenu menu, int heroIndex) {
		this.menu = menu;
		this.heroIndex = heroIndex;
	}

	// Redéfinition de la méthode actionPerformed()
	public void actionPerformed(ActionEvent arg0) {
		menu.setHero(heroIndex);
	}
}