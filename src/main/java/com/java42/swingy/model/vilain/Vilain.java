package com.java42.swingy.model.vilain;

import com.java42.swingy.model.LivingCreature;

public class Vilain extends LivingCreature {
	int XP = 0;
	protected VilainType type;

	public Vilain(int id) {
		this.id = id;
		lostHP = 0;
		this.name = toString();
	}

	public VilainType getType() {
		return type;
	}

	public String getFullDescription() {
		return "Name: " + name + "\nClass: " + toString() + "\nLevel: " + level + " - XP: " + XP + "\nStats:\n\tATK: "
				+ getAttack() + "\n\tDEF: " + getDefense() + "\n\tHP: " + getHP();
	}

	public String getSummary() {
		return "Class: " + toString() + " - Level: " + level + " - Stats: ATK: " + getAttack() + " DEF: "
				+ getDefense() + " HP: " + getHP();
	}

	public String toCsv() {
		return id + "," + name + "," + getType().getValue() + "," + level + "," + XP + "\n";
	}

}
