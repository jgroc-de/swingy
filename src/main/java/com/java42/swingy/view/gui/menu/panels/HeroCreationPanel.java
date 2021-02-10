package com.java42.swingy.view.gui.menu.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.hero.HeroType;
import com.java42.swingy.view.GameMessages;
import com.java42.swingy.view.gui.menu.GuiMenu;
import com.java42.swingy.view.gui.menu.listener.CancelListener;
import com.java42.swingy.view.gui.menu.listener.CreationListener;
import com.java42.swingy.view.gui.menu.listener.TypeListener;

public class HeroCreationPanel extends JPanel {

	final int NAME_LENGHT = 13;
	int type = HeroType.MAGE.getValue();
	HeroClassDescriptionPanel heroPanel;
	GuiMenu menu;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6230453366962272109L;

	public HeroCreationPanel(GuiMenu menu, List<Hero> heroes) {
		super();
		this.menu = menu;
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		setOpaque(false);

		heroPanel = setMiddlePanel(HeroType.MAGE);
		JFormattedTextField nameField = setTopPanel(heroPanel);
		setSouthPanel(menu, nameField);
	}

	public void createHero(String name) {
		menu.createHero(type, name);
	}

	public void setHeroType(HeroType heroType) {
		type = heroType.getValue();
		remove(heroPanel);
		heroPanel = setMiddlePanel(heroType);
		validate();
	}

	private HeroClassDescriptionPanel setMiddlePanel(HeroType heroType) {
		HeroClassDescriptionPanel heroPanel = new HeroClassDescriptionPanel();
		heroPanel.setType(heroType);
		add(heroPanel, BorderLayout.CENTER);
		return heroPanel;
	}

	private JFormattedTextField setTopPanel(HeroClassDescriptionPanel heroPanel) {
		JPanel topPanel = new JPanel();
		JComboBox combo = new JComboBox(HeroType.values());
		JLabel label = new JLabel(GameMessages.CLASS.toString());
		JFormattedTextField nameField = new JFormattedTextField();
		// createFormatter("?".repeat(NAME_LENGHT))

		nameField.setColumns(13);
		combo.addActionListener(new TypeListener(heroPanel, this, combo));
		topPanel.add(label);
		topPanel.add(combo);
		label = new JLabel(GameMessages.NAME.toString());
		topPanel.add(label);
		topPanel.add(nameField);
		add(topPanel, BorderLayout.NORTH);

		return nameField;
	}

	private void setSouthPanel(GuiMenu menu, JFormattedTextField nameField) {
		JButton okButton = new JButton("OK");
		JButton cancelButton = new JButton("Cancel");
		JPanel southPanel = new JPanel();

		okButton.addActionListener(new CreationListener(menu, this, nameField));
		cancelButton.addActionListener(new CancelListener(menu));
		southPanel.add(okButton);
		southPanel.add(cancelButton);
		southPanel.setOpaque(false);
		add(southPanel, BorderLayout.SOUTH);
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
