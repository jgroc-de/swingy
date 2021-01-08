package com.java42.swingy.heroTypes;

public class Mage extends CommonHero {
	public Mage() {
		attackModifier = 4;
		defModifier = 1;
		HPModifier = 1;
		type = HeroType.MAGE;
	}

	@Override
	public String toString() {
		return "Mage";
	}
}
