package com.java42.swingy.model.hero;

public class Warior extends Hero {
	public Warior(int id, String name) {
		super(id, name);
		attackModifier = 2;
		defModifier = 4;
		HPModifier = 2;
		type = HeroType.WARIOR;
	}

	@Override
	public String toString() {
		return "Warior";
	}
}
