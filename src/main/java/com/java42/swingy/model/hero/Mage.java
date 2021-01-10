package com.java42.swingy.model.hero;

public class Mage extends Hero {

	public Mage(int id, String name) {
		super(id, name);
		attackModifier = 5;
		defModifier = 1;
		HPModifier = 1;
		type = HeroType.MAGE;
	}

	@Override
	public String toString() {
		return "Mage";
	}
}
