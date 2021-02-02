package com.java42.swingy.model.artifact;

public class Sword extends Artifact {
	public Sword(int level, ArtifactQuality quality) {
		super(level, quality);
		atkModifier = level * quality.getValue();
		type = ArtifactType.WEAPON;
	}

	public String getStats() {
		return "(atk: " + getAtkModifier() + ")";
	}
}
