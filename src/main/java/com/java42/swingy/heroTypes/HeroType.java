package com.java42.swingy.heroTypes;

public enum HeroType {
	MAGE(1), ROGUE(2), WARIOR(3);

	int value;

	private HeroType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
