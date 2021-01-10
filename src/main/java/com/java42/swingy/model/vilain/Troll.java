package com.java42.swingy.model.vilain;

public class Troll extends Vilain {
	public Troll(int id) {
		super(id);
		attackModifier = 1;
		defModifier = 1;
		HPModifier = 2;
		type = VilainType.TROLL;
	}

	@Override
	public String toString() {
		return "Troll";
	}
}
