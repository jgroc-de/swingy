package com.java42.swingy.view.gui.menu.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.java42.swingy.view.gui.menu.GuiMenu;

public class PlayListener implements ActionListener {
	GuiMenu menu;

	public PlayListener(GuiMenu menu) {
		this.menu = menu;
	}

	// Redéfinition de la méthode actionPerformed()
	public void actionPerformed(ActionEvent arg0) {
		menu.play();
	}
}
