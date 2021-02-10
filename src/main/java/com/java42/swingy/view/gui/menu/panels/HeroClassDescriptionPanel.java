package com.java42.swingy.view.gui.menu.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.java42.swingy.model.hero.HeroType;
import com.java42.swingy.view.gui.menu.buttons.ButtonFactory;

public class HeroClassDescriptionPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8223338645384390558L;
	Insets margin;
	JTextArea textArea;
	HeroType heroType;

	public HeroClassDescriptionPanel() {
		margin = new Insets(200, 200, 200, 200);

		setOpaque(false);
	}

	public void setType(HeroType type) {
		this.heroType = type;
		if (textArea == null) {
			setNewTextArea(type.getStats(), margin);
		} else {
			textArea.removeAll();
			textArea.setText(type.getStats());
			repaint();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		setNewTextArea(heroType.getStats(), margin);
		g.setColor(Color.white);
	}

	private void setNewTextArea(String text, Insets margin) {
		add(ButtonFactory.getNewTextArea(text, margin));
	}
}
