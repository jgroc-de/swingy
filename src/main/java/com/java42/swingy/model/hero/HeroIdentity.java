package com.java42.swingy.model.hero;

public enum HeroIdentity {
	ID(0), NAME(1), CLASS(2), LEVEL(3), XP(4);

	int value;

	HeroIdentity(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
