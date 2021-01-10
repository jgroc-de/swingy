package com.java42.swingy.lib.map;

public class GameMapFactory {
	public static GameMap getGameMap() {
		return new SquareMap();
	}
}
