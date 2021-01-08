package com.java42.swingy.heroTypes;

public class Warior extends CommonHero {
	public Warior() {
		attackModifier = 1;
		defModifier = 2;
		HPModifier = 3;
		type = HeroType.WARIOR;
	}

	@Override
	public String toString() {
		return "Warior";
	}
}
