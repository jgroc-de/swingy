package com.java42.swingy.view.gui.gameBoard;

import com.java42.swingy.controller.GamePlayController;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.view.gui.SwingyFrame;

public class GuiGame {

	SwingyFrame frame;
	GamePlayController controller;

	public GuiGame(SwingyFrame frame) {
		this.frame = frame;
	}

	public void setGameController(GamePlayController controller) {
		this.controller = controller;
	}

	public void printMap(Hero hero) {
		// to do

	}
}
