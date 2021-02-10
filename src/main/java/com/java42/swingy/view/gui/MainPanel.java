package com.java42.swingy.view.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	Container centerPanel;
	Container leftPanel;
	Container rightPanel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3795756414998229209L;

	public MainPanel() {
		super();
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		setTitle();
		setViewTypeSwitch();
		setBackground(Color.black);
	}

	public void setCenterPanel(Container panel) {
		if (centerPanel != null) {
			remove(centerPanel);
		}
		centerPanel = panel;
		add(panel, BorderLayout.CENTER);
	}

	public void setLeftPanel(Container panel) {
		if (leftPanel != null) {
			remove(leftPanel);
		}
		leftPanel = panel;
		add(panel, BorderLayout.WEST);
	}

	public void setRightPanel(Container panel) {
		if (rightPanel != null) {
			remove(rightPanel);
		}
		rightPanel = panel;
		add(panel, BorderLayout.EAST);
	}

	public void setTitle() {
		Font font = new Font("Courier", Font.BOLD, 40);
		JLabel label = new JLabel("Swingy");
		label.setFont(font);
		label.setForeground(Color.red);
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label, BorderLayout.NORTH);
	}

	public void setViewTypeSwitch() {
		JButton button = new JButton("switch to cli");
		add(button, BorderLayout.SOUTH);
	}
}
