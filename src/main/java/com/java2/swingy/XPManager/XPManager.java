package com.java2.swingy.XPManager;

import com.java42.swingy.model.Hero;

public interface XPManager {
	public boolean canLevelUp(int XP, int level);

	public int computeRemainingXP(int XP, int level);

	public void addXP(Hero hero, int XP);
}
