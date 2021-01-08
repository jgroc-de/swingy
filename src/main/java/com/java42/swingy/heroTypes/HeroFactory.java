package com.java42.swingy.heroTypes;

import com.java42.swingy.model.Hero;
import com.java42.swingy.save.HeroIdentity;

public class HeroFactory {
	public static Hero createHero(int heroClass, int id, String name) {
		for (HeroType type : HeroType.values()) {
			if (heroClass == type.getValue()) {
				return new Hero(id, type, name);
			}
		}
		return new Hero(id, HeroType.MAGE, name);
	}

	public static Hero createHeroFromCSV(String[] identity) {
		String name = identity[HeroIdentity.NAME.getValue()];
		int type = Integer.parseInt(identity[HeroIdentity.CLASS.getValue()]);
		int level = Integer.parseInt(identity[HeroIdentity.LEVEL.getValue()]);
		int XP = Integer.parseInt(identity[HeroIdentity.XP.getValue()]);
		Hero hero = createHero(type, Integer.parseInt(identity[HeroIdentity.ID.getValue()]), name);
		hero.setLevel(level);
		hero.setXP(XP);

		return hero;
	}
}
