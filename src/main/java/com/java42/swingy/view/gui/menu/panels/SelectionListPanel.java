package com.java42.swingy.view.gui.menu.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
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

	public void paintComponent(Graphics graphics) {
		setBackground(graphics);
	}

	private Graphics2D setBackground(Graphics graphics) {
		Graphics2D graphics2d = (Graphics2D) graphics;
		GradientPaint gradientPaint = new GradientPaint(0, 0, Color.BLACK, 0, this.getHeight(), Color.GRAY, false);
		graphics2d.setPaint(gradientPaint);
		graphics2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		return graphics2d;
	}

	public void setMainTitle() {
		Font font = new Font("Courier", Font.BOLD, 40);
		JLabel label = new JLabel("Swingy");
		label.setFont(font);
		label.setForeground(Color.red);
		label.setHorizontalAlignment(JLabel.CENTER);
		this.add(label);
	}
}
