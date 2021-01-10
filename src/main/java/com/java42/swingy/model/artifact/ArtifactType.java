package com.java42.swingy.model.artifact;

public enum ArtifactType {
	WEAPON(1), ARMOR(2), HELM(3);

	int value;

	ArtifactType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static ArtifactType getRandom() {
		for (ArtifactType type : ArtifactType.values()) {
			if (Math.random() > 0.5) {
				return type;
			}
		}
		return HELM;
	}
}
