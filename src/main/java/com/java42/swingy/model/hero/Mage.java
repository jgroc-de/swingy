package com.java42.swingy.model.hero;

public class Mage extends Hero {

	public Mage(int id, String name) {
		super(id, name, HeroType.MAGE);
	}

	@Override
	public String toString() {
		return "Mage";
	}
}
