package com.java42.swingy.lib.map;

import java.util.List;

import com.java42.swingy.model.LivingCreature;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;

public class SquareMap {
	int mapSize;
	List<Vilain> vilains;

	public void setVilains(List<Vilain> vilains) {
		this.vilains = vilains;
	}

	public List<Vilain> getVilains() {
		return vilains;
	}

	public void setMapSize(int level) {
		mapSize = (level - 1) * 5 + 10 - 1;
	}

	public int getMapSize() {
		return mapSize;
	}

	public boolean isOutOfMap(int X, int Y) {
		if (X <= 1 || X > mapSize - 1) {
			return true;
		}
		if (Y <= 1 || Y > mapSize - 1) {
			return true;
		}
		return false;
	}

	public void setInitialMapPosition(Hero hero) {
		int middle = (mapSize + 1) / 2;

		hero.setX(middle);
		hero.setY(middle);
	}

	public int getNbOfVilains() {
		return (int) (Math.pow(mapSize, 2) / 4);
	}

	public void setVilainsPosition() {
		for (Vilain vilain : vilains) {
			vilain.setX((int) (Math.random() * (mapSize - 2) + 2));
			vilain.setY((int) (Math.random() * (mapSize - 2) + 2));
		}
	}

	public boolean isLivingPosition(LivingCreature livingCreature, int y, int x) {
		return y == livingCreature.getY() && x == livingCreature.getX();
	}

	public boolean isVilainPosition(int y, int x) {
		for (Vilain vilain : vilains) {
			if (isLivingPosition(vilain, y, x)) {
				return true;
			}
		}
		return false;
	}

	public Vilain getVilainFromPosition(int X, int Y) throws Exception {
		for (Vilain vilain : vilains) {
			if (isLivingPosition(vilain, X, Y)) {
				return vilain;
			}
		}
		throw new Exception("error somewhere…");
	}
}
