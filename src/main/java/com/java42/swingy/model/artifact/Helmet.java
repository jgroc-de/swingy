package com.java42.swingy.model.artifact;

public class Helmet extends Artifact {
	public Helmet(int level, ArtifactQuality quality) {
		super(level, quality);
		HPModifier = level * quality.getValue();
		type = ArtifactType.HELM;
	}
}
