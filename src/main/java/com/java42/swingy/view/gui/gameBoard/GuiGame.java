package com.java42.swingy.view.gui.gameBoard;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.java42.swingy.controller.GamePlayController;
import com.java42.swingy.lib.map.SquareMap;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.view.gui.SwingyFrame;
import com.java42.swingy.view.gui.gameBoard.panels.RightGamePanel;

public class GuiGame {

	SwingyFrame frame;
	GamePlayController controller;
	SquareMap gameMap;
	boolean isVisible = true;

	public GuiGame(SwingyFrame frame) {
		this.frame = frame;
	}

	public void setGameController(GamePlayController controller) {
		this.controller = controller;
	}

	public void setGameMap(SquareMap gameMap) {
		this.gameMap = gameMap;
	}

	private boolean isPossibleMove(Hero hero, int x, int y) {
		if (y == hero.getY() && (x == hero.getX() - 1 || x == hero.getX() + 1)) {
			return true;
		}
		if (x == hero.getX() && (y == hero.getY() - 1 || y == hero.getY() + 1)) {
			return true;
		}
		return false;
	}

	private Color getColor(Hero hero, int x, int y) {
		if (gameMap.isLivingPosition(hero, y, x)) {
			if (gameMap.isVilainPosition(y, x)) {
				return Color.cyan;
			}
			return Color.blue;
		}
		if (gameMap.isVilainPosition(y, x)) {
			if (isPossibleMove(hero, x, y)) {
				return Color.BLACK;
			}
			return Color.red;
		}
		if (isPossibleMove(hero, x, y)) {
			return Color.green;
		}
		return Color.gray;
	}

	public void printMap(Hero hero) {
		int mapSize = gameMap.getMapSize();
		int y = 0;
		int x;
		Color color;

		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		Container tmpCell;
		panel.setLayout(new GridLayout(mapSize, mapSize, 2, 2));
		System.out.println(hero.getX() + " - " + hero.getY());
		while (y++ < mapSize) {
			x = 0;
			while (x++ < mapSize) {
				if (isPossibleMove(hero, x, y)) {
					tmpCell = new JButton(String.valueOf(x) + " - " + String.valueOf(y));
				} else {
					tmpCell = new JPanel();
				}

				color = getColor(hero, x, y);
				tmpCell.setBackground(color);
				panel.add(tmpCell);
			}

		}
		frame.setContentPane(panel);
		frame.setRightPanel(new RightGamePanel(hero));
		frame.setVisible(true);
	}
}
