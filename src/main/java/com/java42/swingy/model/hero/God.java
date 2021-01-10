package com.java42.swingy.model.hero;

public class God extends Hero {
	public God(int id, String name) {
		super(id, name);
		attackModifier = 10;
		defModifier = 10;
		HPModifier = 10;
		type = HeroType.GOD;
	}

	@Override
	public String toString() {
		return "God";
	}
}
