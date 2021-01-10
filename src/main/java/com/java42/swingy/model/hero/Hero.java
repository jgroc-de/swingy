package com.java42.swingy.model.hero;

import com.java42.swingy.model.LivingCreature;
import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.artifact.ArtifactFactory;
import com.java42.swingy.model.artifact.ArtifactQuality;
import com.java42.swingy.model.artifact.ArtifactType;

public abstract class Hero extends LivingCreature {
	int XP = 0;
	HeroType type;

	Artifact helm;
	Artifact sword;
	Artifact armor;

	public Hero(int id, String name) {
		this.id = id;
		lostHP = 0;
		setName(name);
		helm = ArtifactFactory.createArtifact(ArtifactType.HELM, ArtifactQuality.WOOD, 0);
		sword = ArtifactFactory.createArtifact(ArtifactType.WEAPON, ArtifactQuality.WOOD, 0);
		armor = ArtifactFactory.createArtifact(ArtifactType.ARMOR, ArtifactQuality.WOOD, 0);
	}

	public void setArtifact(Artifact artifact) {
		switch (artifact.getType()) {
		case WEAPON:
			if (artifact.getLevel() > sword.getLevel()) {
				sword = artifact;
			}
			break;
		case ARMOR:
			if (artifact.getLevel() > armor.getLevel()) {
				armor = artifact;
			}
			break;
		case HELM:
			if (artifact.getLevel() > helm.getLevel()) {
				helm = artifact;
			}
			break;
		}
	}

	public HeroType getType() {
		return type;
	}

	public void move(int X, int Y) {
		xOnMap += X;
		yOnMap += Y;
	}

	public void resetLostHP() {
		lostHP = 0;
	}

	public int getXP() {
		return XP;
	}

	public void setXP(int XP) {
		this.XP = XP;
	}

	public void levelUP() {
		this.level += 1;
		lostHP = 0;
	}

	public int getAttack() {
		int modifier = sword.getAtkModifier();
		return super.getAttack() + modifier;
	}

	public int getDefense() {
		int modifier = armor.getDefModifier();
		return super.getDefense() + modifier;
	}

	public int getHP() {
		int modifier = helm.getHPModifier();
		return super.getHP() + modifier;
	}

	public String getFullDescription() {
		return "Name: " + name + "\nClass: " + toString() + "\nLevel: " + level + " - XP: " + XP + "\nStats:\n\tATK: "
				+ getAttack() + "\n\tDEF: " + getDefense() + "\n\tHP: " + getHP() + "\nEquipement\n\t"
				+ sword.getDescription() + "\n\t" + armor.getDescription() + "\n\t" + helm.getDescription() + "\n";
	}

	public String getSummary() {
		return "Name: " + name + " - Class: " + toString() + " - Level: " + level + " - XP: " + XP + " - Stats: ATK: "
				+ getAttack() + " DEF: " + getDefense() + " HP: " + getHP();
	}

	public String toCsv() {
		return id + "," + name + "," + getType().getValue() + "," + level + "," + XP + "\n";
	}
}
