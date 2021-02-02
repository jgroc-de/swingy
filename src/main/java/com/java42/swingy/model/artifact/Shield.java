package com.java42.swingy.model.artifact;

public class Shield extends Artifact {
	public Shield(int level, ArtifactQuality quality) {
		super(level, quality);
		defModifier = level * quality.getValue();
		type = ArtifactType.ARMOR;
	}

	public String getStats() {
		return "(def: " + getDefModifier() + ")";
	}
}
