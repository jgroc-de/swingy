package com.java42.swingy.model.hero;

public class God extends Hero {
	public God(int id, String name) {
		super(id, name, HeroType.GOD);
	}

	@Override
	public String toString() {
		return "God";
	}
}
