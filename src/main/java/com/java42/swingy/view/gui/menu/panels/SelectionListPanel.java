package com.java42.swingy.view.gui.menu.panels;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.view.gui.menu.GuiMenu;
import com.java42.swingy.view.gui.menu.buttons.ButtonFactory;

public class SelectionListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<JButton> buttons = new ArrayList<JButton>();

	public SelectionListPanel(GuiMenu menu, List<Hero> heroes) {
		super();
		GridLayout layout = new GridLayout(heroes.size(), 1, 0, 15);
		setLayout(layout);
		setOpaque(false);
		setButtons(menu, heroes);
	}

	public void setButtons(GuiMenu menu, List<Hero> heroes) {
		JPanel button;
		int index = 1;
		for (Hero hero : heroes) {
			button = ButtonFactory.getHeroButton(menu, hero, index++);
			add(button);
		}
	}

}
