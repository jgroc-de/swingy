package com.java42.swingy.view.gui.menu.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.java42.swingy.controller.MenuItem;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.view.gui.menu.GuiMenu;
import com.java42.swingy.view.gui.menu.listener.CreateHeroListener;
import com.java42.swingy.view.gui.menu.listener.HeroSelectedListener;
import com.java42.swingy.view.gui.menu.listener.PlayListener;
import com.java42.swingy.view.gui.menu.listener.QuitListener;
import com.java42.swingy.view.gui.menu.listener.SelectHeroListener;

public class ButtonFactory {
	public static MenuButton getButton(GuiMenu menu, MenuItem type) {
		MenuButton button = new MenuButton(type.getLabel());
		button.setBackground(Color.red);
		switch (type) {
		case HERO_CREATION:
			button.addActionListener(new CreateHeroListener(menu));
			break;
		case HERO_SELECTION:
			button.addActionListener(new SelectHeroListener(menu));
			break;
		case PLAY:
			button.addActionListener(new PlayListener(menu));
			break;
		case QUIT:
			button.addActionListener(new QuitListener(menu));
			break;
		}

		return button;

	}

	public static JPanel getHeroButton(GuiMenu menu, Hero hero, int index) {
		MenuButton button = new MenuButton(hero.getName());
		JPanel panel;
		GridLayout layout;
		Insets margin = new Insets(10, 10, 10, 10);
		layout = new GridLayout(2, 2, 10, 10);
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(layout);

		button.addActionListener(new HeroSelectedListener(menu, index));
		panel.setPreferredSize(new Dimension(400, 200));
		panel.add(button);
		panel.add(getNewTextArea(hero.getBasicInfo(), margin));
		panel.add(getNewTextArea(hero.getEquipement(), margin));
		panel.add(getNewTextArea(hero.getStats(), margin));

		return panel;

	}

	static public JTextArea getNewTextArea(String text, Insets margin) {
		JTextArea textArea = new JTextArea(text);
		Font font = new Font("Courier", Font.PLAIN, 12);

		textArea.setForeground(Color.red);
		textArea.setFont(font);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setMargin(margin);
		return textArea;
	}
}
