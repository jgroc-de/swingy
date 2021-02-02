package com.java42.swingy.model.hero;

public class Warior extends Hero {
	public Warior(int id, String name) {
		super(id, name, HeroType.WARIOR);
	}

	@Override
	public String toString() {
		return "Warior";
	}
}
