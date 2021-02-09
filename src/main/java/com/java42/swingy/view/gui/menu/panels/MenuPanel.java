package com.java42.swingy.view.gui.menu.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.java42.swingy.controller.MenuItem;
import com.java42.swingy.view.gui.menu.GuiMenu;
import com.java42.swingy.view.gui.menu.buttons.ButtonFactory;

public class MenuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 73111626817024958L;

	public MenuPanel(GuiMenu menu, boolean heroIsSet, boolean noHeroes) {
		super();
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 800, 350);
		setLayout(layout);
		setButtons(menu, heroIsSet, noHeroes);
	}

	public void setButtons(GuiMenu menu, boolean heroIsSet, boolean noHeroes) {
		JButton button;
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		for (MenuItem item : MenuItem.values()) {
			if (item.canDoThis(heroIsSet, noHeroes)) {
				button = ButtonFactory.getButton(menu, item);
				panel.add(button);
			}
		}
		add(panel);
	}

	@Override
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
}
