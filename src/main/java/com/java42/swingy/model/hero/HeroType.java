package com.java42.swingy.model.hero;

public enum HeroType {
	MAGE(1, 5, 1, 1), ROGUE(2, 4, 1, 3), WARIOR(3, 2, 4, 2), GOD(4, 10, 10, 10);

	int value;
	int atk;
	int def;
	int hp;

	private HeroType(int value, int atk, int def, int hp) {
		this.value = value;
		this.atk = atk;
		this.def = def;
		this.hp = hp;
	}

	public int getATK() {
		return atk;
	}

	public int getDEF() {
		return def;
	}

	public int getHP() {
		return hp;
	}

	public int getValue() {
		return value;
	}

	public static boolean isType(int choice) {
		for (HeroType type : HeroType.values()) {
			if (choice == type.getValue()) {
				return true;
			}
		}
		
		return false;
	}
	
	public static HeroType getType(int heroType) {
		for (HeroType type : HeroType.values()) {
			if (type.getValue() == heroType) {
				return type;
			}
		}
		return HeroType.MAGE;
	}

	public String getStats() {
		return "Atk: " + getATK() + "\nDef: " + getDEF() + "\nHP: " + (getHP() + 8);
	}

}
