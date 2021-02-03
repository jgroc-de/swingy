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

	public static ArtifactQuality getArtifactByValue(int value) throws Exception {
		for (ArtifactQuality quality : ArtifactQuality.values()) {
			if (quality.getValue() == value) {
				return quality;
			}
		}
		throw new Exception("not a valid quality");
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
