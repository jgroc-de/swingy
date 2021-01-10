package com.java42.swingy.model.artifact;

public enum ArtifactQuality {
	WOOD(1), IRON(2), STEEL(3);

	int value;

	ArtifactQuality(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static ArtifactQuality getRandom() {
		for (ArtifactQuality quality : ArtifactQuality.values()) {
			if (Math.random() > 0.33) {
				return quality;
			}
		}
		return STEEL;
	}
}
