package com.java42.swingy.view.gui.menu.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import com.java42.swingy.model.hero.HeroType;
import com.java42.swingy.view.gui.menu.panels.HeroClassDescriptionPanel;
import com.java42.swingy.view.gui.menu.panels.HeroCreationPanel;

public class TypeListener implements ActionListener {
	HeroClassDescriptionPanel panel;
	JComboBox combo;
	HeroCreationPanel mainPanel;

	public TypeListener(HeroClassDescriptionPanel panel, HeroCreationPanel mainPanel, JComboBox combo) {
		this.panel = panel;
		this.combo = combo;
		this.mainPanel = mainPanel;
	}

	public void actionPerformed(ActionEvent e) {
		HeroType heroType = (HeroType) combo.getSelectedItem();
		mainPanel.setHeroType(heroType);
	}
}
