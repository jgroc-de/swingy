package com.java42.swingy.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public abstract class LivingCreature {
	@NotNull
	protected int id;
	@NotNull
	protected String name;
	@Positive
	protected int level = 1;
	@PositiveOrZero
	protected int lostHP;
	@PositiveOrZero
	protected int xOnMap;
	@PositiveOrZero
	protected int yOnMap;
	@PositiveOrZero
	int attack = 0;
	@PositiveOrZero
	int def = 0;
	@PositiveOrZero
	int HP = 8;
	@PositiveOrZero
	protected int attackModifier;
	@PositiveOrZero
	protected int defModifier;
	@PositiveOrZero
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
