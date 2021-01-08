package com.java42.swingy.heroTypes;

public abstract class CommonHero {
	int attack = 0;
	int def = 0;
	int HP = 8;
	int attackModifier;
	int defModifier;
	int HPModifier;
	HeroType type;

	public int getAttack(int level) {
		return attack + attackModifier * level;
	}

	public int getDeffense(int level) {
		return def + defModifier * level;
	}

	public int getHP(int level) {
		return HP + HPModifier * 2 * level;
	}

	public HeroType getType() {
		return type;
	}
}
