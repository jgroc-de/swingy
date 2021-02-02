package com.java42.swingy.model.hero;

public class Rogue extends Hero {
	public Rogue(int id, String name) {
		super(id, name, HeroType.ROGUE);
	}

	@Override
	public String toString() {
		return "Rogue";
	}
}
