package com.java42.swingy.lib.XPManager;

import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;

public interface XPManager {
	public boolean canLevelUp(int XP, int level);

	public int computeRemainingXP(int XP, int level);

	public void addXP(Hero hero, Vilain vilain);

	public int getXP(Vilain vilain);
}
