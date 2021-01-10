package com.java42.swingy.lib.XPManager;

import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;

public class XPSwingy implements XPManager {
	public boolean canLevelUp(int XP, int level) {
		return XP >= XPNeededForLevelUp(level);
	}

	public int computeRemainingXP(int XP, int level) {
		return XP - XPNeededForLevelUp(level);
	}

	private int XPNeededForLevelUp(int level) {
		return (int) (level * 1000 + Math.pow(level - 1, 2) * 450);
	}

	public void addXP(Hero hero, Vilain vilain) {
		int xpIfLevelUP;
		int currentXP = hero.getXP() + getXP(vilain);
		hero.setXP(currentXP);
		while ((xpIfLevelUP = computeRemainingXP(currentXP, hero.getLevel())) >= 0) {
			hero.levelUP();
			hero.setXP(xpIfLevelUP);
			currentXP = xpIfLevelUP;
		}
	}

	public int getXP(Vilain vilain) {
		return (int) (400 * vilain.getLevel());
	}
}
