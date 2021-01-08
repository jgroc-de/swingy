package com.java42.swingy.heroTypes;

public class Rogue extends CommonHero {
	public Rogue() {
		attackModifier = 3;
		defModifier = 1;
		HPModifier = 2;
		type = HeroType.ROGUE;
	}

	@Override
	public String toString() {
		return "Rogue";
	}
}
