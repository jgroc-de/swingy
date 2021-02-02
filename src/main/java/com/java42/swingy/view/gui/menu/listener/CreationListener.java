package com.java42.swingy.view.gui.menu.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;

import com.java42.swingy.view.gui.menu.GuiMenu;
import com.java42.swingy.view.gui.menu.panels.HeroCreationPanel;

public class CreationListener implements ActionListener {
	GuiMenu menu;
	JFormattedTextField nameField;
	HeroCreationPanel panel;

	public CreationListener(GuiMenu menu, HeroCreationPanel panel, JFormattedTextField nameField) {
		this.menu = menu;
		this.nameField = nameField;
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) {
		String name = nameField.getText();
		System.out.println(name);
		if (name.isEmpty()) {
			menu.menuActions();
		} else {
			panel.createHero(name);
		}
	}
}