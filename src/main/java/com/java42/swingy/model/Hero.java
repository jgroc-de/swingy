package com.java42.swingy.model;

import com.java42.swingy.heroTypes.CommonHero;
import com.java42.swingy.heroTypes.HeroType;
import com.java42.swingy.heroTypes.Mage;
import com.java42.swingy.heroTypes.Rogue;
import com.java42.swingy.heroTypes.Warior;

public class Hero {
	int heroID;
	String name;
	CommonHero heroClass;
	int level = 1;
	int XP = 0;
	int lostHP;
	int xOnMap;
	int yOnMap;

	// Artifact helm;
	// Artifact sword;
	// Artifact armor;

	public Hero(int id, HeroType type, String name) {
		heroID = id;
		lostHP = 0;
		switch (type) {
		case MAGE:
			this.heroClass = new Mage();
			break;
		case ROGUE:
			this.heroClass = new Rogue();
			break;
		case WARIOR:
			this.heroClass = new Warior();
			break;
		}
		setName(name);
	}

	public int getID() {
		return heroID;
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

	public void move(int X, int Y) {
		xOnMap += X;
		yOnMap += Y;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getXP() {
		return XP;
	}

	public void setXP(int XP) {
		this.XP = XP;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void levelUP() {
		this.level += 1;
		lostHP = 0;
	}

	public CommonHero getType() {
		return heroClass;
	}

	public int getHP() {
		return heroClass.getHP(level) - lostHP;
	}

	public void setLostHP(int lostHP) {
		this.lostHP += lostHP;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nClass: " + heroClass + "\nLevel: " + level + " - XP: " + XP + "\nStats:\n\tATK: "
				+ heroClass.getAttack(level) + "\n\tDEF: " + heroClass.getDeffense(level) + "\n\tHP: "
				+ heroClass.getHP(level);
	}

	public String getSummary() {
		return "Name: " + name + " Class: " + heroClass + " Level: " + level + " - XP: " + XP + " - Stats: ATK: "
				+ heroClass.getAttack(level) + " DEF: " + heroClass.getDeffense(level) + " HP: "
				+ heroClass.getHP(level);
	}

	public String toCsv() {
		return heroID + "," + name + "," + heroClass.getType().getValue() + "," + level + "," + XP + "\n";
	}
}
