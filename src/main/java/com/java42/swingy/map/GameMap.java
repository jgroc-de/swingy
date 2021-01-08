package com.java42.swingy.map;

import com.java42.swingy.model.Hero;

public class GameMap {
	public int getMapSize(int level) {
		return (level - 1) * 5 + 10 - 1;
	}

	public boolean isOutOfMap(int level, int X, int Y) {
		int size = getMapSize(level);
		if (X <= 1 || X > size - 1) {
			return true;
		}
		if (Y <= 1 || Y > size - 1) {
			return true;
		}
		return false;
	}

	public void setInitialMapPosition(Hero hero) {
		int size = getMapSize(hero.getLevel());
		int middle = (size + 1) / 2;
		hero.setX(middle);
		hero.setY(middle);
	}
}
