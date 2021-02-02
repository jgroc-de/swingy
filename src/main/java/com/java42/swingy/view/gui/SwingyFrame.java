package com.java42.swingy.view.gui;

import javax.swing.JFrame;

public class SwingyFrame extends JFrame {

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
	}
}
