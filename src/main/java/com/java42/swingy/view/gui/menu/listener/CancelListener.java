package com.java42.swingy.view.gui.menu.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.java42.swingy.view.gui.menu.GuiMenu;

public class CancelListener implements ActionListener {
	GuiMenu menu;

	public CancelListener(GuiMenu menu) {
		this.menu = menu;
	}

	public void actionPerformed(ActionEvent e) {
		menu.menuActions();
	}
}