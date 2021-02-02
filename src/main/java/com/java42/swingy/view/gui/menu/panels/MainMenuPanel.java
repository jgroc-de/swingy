package com.java42.swingy.view.gui.menu.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.java42.swingy.controller.MenuItem;
import com.java42.swingy.view.gui.menu.GuiMenu;
import com.java42.swingy.view.gui.menu.buttons.ButtonFactory;

public class MainMenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<JButton> buttons = new ArrayList<JButton>();

	public MainMenuPanel(GuiMenu menu, boolean heroIsSet, boolean noHeroes) {
		super();
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 800, 200);
		setLayout(layout);
		setMainTitle();
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
		add(label);
	}

}
