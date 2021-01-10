package com.java42.swingy.model.hero;

public class HeroFactory {
	public static Hero createHero(HeroType heroClass, int id, String name) {
		switch (heroClass) {
		case MAGE:
			return new Mage(id, name);
		case ROGUE:
			return new Rogue(id, name);
		case WARIOR:
			return new Warior(id, name);
		case GOD:
			return new God(id, name);
		default:
			return new Mage(id, name);
		}

	}

	public static Hero createHeroFromCSV(String[] identity) {
		String name = identity[HeroIdentity.NAME.getValue()];
		int type = Integer.parseInt(identity[HeroIdentity.CLASS.getValue()]);
		int level = Integer.parseInt(identity[HeroIdentity.LEVEL.getValue()]);
		int XP = Integer.parseInt(identity[HeroIdentity.XP.getValue()]);
		HeroType heroClass = HeroType.getType(type);
		Hero hero = createHero(heroClass, Integer.parseInt(identity[HeroIdentity.ID.getValue()]), name);
		hero.setLevel(level);
		hero.setXP(XP);

		return hero;
	}
}
