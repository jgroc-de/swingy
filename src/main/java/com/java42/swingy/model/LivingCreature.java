package com.java42.swingy.model;

public abstract class LivingCreature {
	protected int id;
	protected String name;
	protected int level = 1;
	protected int lostHP;
	protected int xOnMap;
	protected int yOnMap;
	int attack = 0;
	int def = 0;
	int HP = 8;
	protected int attackModifier;
	protected int defModifier;
	protected int HPModifier;

	public int getAttack() {
		return attack + attackModifier * level;
	}

	public int getDefense() {
		return def + defModifier * level;
	}

	public int getHP() {
		return HP + HPModifier * 2 * level - lostHP;
	}

	public int getID() {
		return id;
	}

	public int getX() {
		return xOnMap;
	}

	public void setX(int xOnMap) {
		this.xOnMap = xOnMap;
	}

	public int getY() {
		return yOnMap;
	}

	public void setY(int yOnMap) {
		this.yOnMap = yOnMap;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void addLostHP(int lostHP) {
		if (lostHP > 0) {
			this.lostHP += lostHP;
		}
	}
}
