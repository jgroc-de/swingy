package com.java42.swingy.model.vilain;

public class Skeletton extends Vilain {
	public Skeletton(int id) {
		super(id);
		attackModifier = 3;
		defModifier = 1;
		HPModifier = 1;
		type = VilainType.SKELETTON;
	}

	@Override
	public String toString() {
		return "Skeletton";
	}
}
