package com.java42.swingy.view.gui.gameBoard.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.java42.swingy.model.hero.Hero;

public class RightGamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7933572298646858542L;

	public RightGamePanel(Hero hero) {
		super();
		setLayout(new GridLayout(3, 1, 10, 10));
		add(getDescriptionPanel(hero));
		add(new JLabel("Click where you want to move"));
		add(new JLabel("last battle"));
		setBackground(Color.gray);
	}

	private JTextArea getDescriptionPanel(Hero hero) {
		JTextArea textArea = new JTextArea(hero.getFullDescription());
		Font font = new Font("Courier", Font.PLAIN, 12);
		Insets margin = new Insets(20, 20, 20, 20);

		textArea.setEditable(false);
		textArea.setMargin(margin);
		textArea.setFont(font);
		textArea.setForeground(Color.red);
		textArea.setBackground(Color.black);
		textArea.setPreferredSize(new Dimension(300, 100));

		return textArea;
	}

}
