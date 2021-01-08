package com.java2.swingy.XPManager;

import com.java42.swingy.model.Hero;

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

	public void addXP(Hero hero, int XP) {
		int currentXP = hero.getXP() + XP;
		if (hero.getXP() == 0) {
			hero.setXP(XP);
		}
		int xpIfLevelUP;
		while ((xpIfLevelUP = computeRemainingXP(currentXP, hero.getLevel())) >= 0) {
			hero.levelUP();
			hero.setXP(xpIfLevelUP);
			currentXP = xpIfLevelUP;
		}
	}
}
