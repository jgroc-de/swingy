package com.java42.swingy.model.hero;

public enum HeroType {
	MAGE(1), ROGUE(2), WARIOR(3), GOD(4);

	int value;

	private HeroType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static HeroType getType(int heroType) {
		for (HeroType type : HeroType.values()) {
			if (type.getValue() == heroType) {
				return type;
			}
		}
		return HeroType.MAGE;
	}

}
