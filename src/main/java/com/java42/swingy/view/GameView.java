package com.java42.swingy.view;

import com.java42.swingy.map.Direction;

public interface GameView extends View {
	public void printMap(int level, int heroX, int heroY);

	public Direction promptForDirection();

	public void printEndOfGame(boolean victory);
}
