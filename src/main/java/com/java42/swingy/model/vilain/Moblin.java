package com.java42.swingy.model.vilain;

public class Moblin extends Vilain {
	public Moblin(int id) {
		super(id);
		attackModifier = 2;
		defModifier = 1;
		HPModifier = 1;
		type = VilainType.MOBLIN;
	}

	@Override
	public String toString() {
		return "Moblin";
	}
}
