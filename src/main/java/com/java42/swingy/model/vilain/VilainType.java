package com.java42.swingy.model.vilain;

public enum VilainType {
	TROLL(1), MOBLIN(2), SKELETTON(3), DRAGON(4);

	int value;

	private VilainType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static VilainType getType(int vilainType) {
		for (VilainType type : VilainType.values()) {
			if (type.getValue() == vilainType) {
				return type;
			}
		}
		return VilainType.TROLL;
	}

	public static VilainType getRandomType() {
		int random = (int) (Math.random() * 3 + 1);
		return getType(random);
	}
}
