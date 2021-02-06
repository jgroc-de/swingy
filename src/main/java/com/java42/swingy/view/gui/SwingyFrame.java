package com.java42.swingy.view.gui;

import java.awt.Container;

import javax.swing.JFrame;

public class SwingyFrame extends JFrame {
	MainPanel mainPanel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SwingyFrame() {
		this.setTitle("Swingy");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new MainPanel();
		super.setContentPane(mainPanel);
	}

	@Override
	public void setContentPane(Container panel) {
		mainPanel.setCenterPanel(panel);
	}

	public void setLeftPanel(Container panel) {
		mainPanel.setLeftPanel(panel);
	}

	public void setRightPanel(Container panel) {
		mainPanel.setRightPanel(panel);
	}
}
