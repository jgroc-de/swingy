package com.java42.swingy.model.vilain;

public class Dragon extends Vilain {
	public Dragon(int id) {
		super(id);
		attackModifier = 3;
		defModifier = 1;
		HPModifier = 2;
		type = VilainType.MOBLIN;
	}

	@Override
	public String toString() {
		return "Dragon";
	}
}
