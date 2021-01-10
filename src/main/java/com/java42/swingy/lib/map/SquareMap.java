package com.java42.swingy.lib.map;

import java.util.List;

import com.java42.swingy.model.LivingCreature;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;

public class SquareMap implements GameMap {
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

	public void setInitialMapPosition(Hero hero, int size) {
		int middle = (size + 1) / 2;

		hero.setX(middle);
		hero.setY(middle);
	}

	public int getNbOfVilains(int size) {
		return (int) (Math.pow(size, 2) / 4);
	}

	public void setVilainsPosition(List<Vilain> vilains, int size) {
		for (Vilain vilain : vilains) {
			vilain.setX((int) (Math.random() * (size - 2) + 2));
			vilain.setY((int) (Math.random() * (size - 2) + 2));
		}
	}

	public boolean isLivingPosition(LivingCreature livingCreature, int y, int x) {
		return y == livingCreature.getY() && x == livingCreature.getX();
	}

	public boolean isVilainPosition(List<Vilain> vilains, int y, int x) {
		for (Vilain vilain : vilains) {
			if (isLivingPosition(vilain, y, x)) {
				return true;
			}
		}
		return false;
	}

	public Vilain getVilainFromPosition(List<Vilain> vilains, int X, int Y) throws Exception {
		for (Vilain vilain : vilains) {
			if (isLivingPosition(vilain, X, Y)) {
				return vilain;
			}
		}
		throw new Exception("error somewhere…");
	}
}
