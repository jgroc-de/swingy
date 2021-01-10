package com.java42.swingy.model.artifact;

public class ArtifactFactory {
	public static Artifact createArtifact(ArtifactType artifactClass, ArtifactQuality quality, int level) {
		switch (artifactClass) {
		case WEAPON:
			return new Sword(level, quality);
		case ARMOR:
			return new Shield(level, quality);
		case HELM:
			return new Helmet(level, quality);
		default:
			return new Sword(level, quality);
		}

	}

	public static Artifact getRandomArtifact(int level) {
		ArtifactType artifactClass = ArtifactType.getRandom();
		ArtifactQuality quality = ArtifactQuality.getRandom();
		return createArtifact(artifactClass, quality, level);
	}
}
