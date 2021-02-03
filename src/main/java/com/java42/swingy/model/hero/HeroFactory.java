package com.java42.swingy.model.hero;

import com.java42.swingy.model.artifact.Artifact;
import com.java42.swingy.model.artifact.ArtifactFactory;
import com.java42.swingy.model.artifact.ArtifactQuality;
import com.java42.swingy.model.artifact.ArtifactType;

public class HeroFactory {
	public static Hero createHero(HeroType heroClass, int id, String name) {
		switch (heroClass) {
		case MAGE:
			return new Mage(id, name);
		case ROGUE:
			return new Rogue(id, name);
		case WARIOR:
			return new Warior(id, name);
		case GOD:
			return new God(id, name);
		default:
			return new Mage(id, name);
		}

	}

	public static Hero createHeroFromCSV(String[] identity) throws Exception {
		Hero hero = createHero(getHeroType(identity), getID(identity), getName(identity));
		hero.setLevel(getLevel(identity));
		hero.setXP(getXP(identity));
		hero.setArtifact(getSword(identity));
		hero.setArtifact(getArmor(identity));
		hero.setArtifact(getHelm(identity));

		return hero;
	}

	private static Artifact getSword(String[] identity) throws Exception {
		int level = Integer.parseInt(identity[HeroIdentity.SWORD.getValue() + 1]);
		int qualityValue = Integer.parseInt(identity[HeroIdentity.SWORD.getValue()]);
		ArtifactQuality quality = ArtifactQuality.getArtifactByValue(qualityValue);
		Artifact artifact = ArtifactFactory.createArtifact(ArtifactType.WEAPON, quality, level);

		return artifact;
	}

	private static Artifact getArmor(String[] identity) throws Exception {
		int level = Integer.parseInt(identity[HeroIdentity.ARMOR.getValue() + 1]);
		int qualityValue = Integer.parseInt(identity[HeroIdentity.ARMOR.getValue()]);
		ArtifactQuality quality = ArtifactQuality.getArtifactByValue(qualityValue);
		Artifact artifact = ArtifactFactory.createArtifact(ArtifactType.ARMOR, quality, level);

		return artifact;
	}

	private static Artifact getHelm(String[] identity) throws Exception {
		int level = Integer.parseInt(identity[HeroIdentity.HELM.getValue() + 1]);
		int qualityValue = Integer.parseInt(identity[HeroIdentity.HELM.getValue()]);
		ArtifactQuality quality = ArtifactQuality.getArtifactByValue(qualityValue);
		Artifact artifact = ArtifactFactory.createArtifact(ArtifactType.HELM, quality, level);

		return artifact;
	}

	private static int getID(String[] identity) {
		return Integer.parseInt(identity[HeroIdentity.ID.getValue()]);
	}

	private static String getName(String[] identity) {
		return identity[HeroIdentity.NAME.getValue()];
	}

	private static HeroType getHeroType(String[] identity) {
		return HeroType.getType(Integer.parseInt(identity[HeroIdentity.CLASS.getValue()]));
	}

	private static int getLevel(String[] identity) {
		return Integer.parseInt(identity[HeroIdentity.LEVEL.getValue()]);
	}

	private static int getXP(String[] identity) {
		return Integer.parseInt(identity[HeroIdentity.XP.getValue()]);
	}
}
