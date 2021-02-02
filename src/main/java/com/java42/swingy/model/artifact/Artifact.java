package com.java42.swingy.model.artifact;

public abstract class Artifact {
	protected int atkModifier = 0;
	protected int defModifier = 0;
	protected int HPModifier = 0;
	int level;
	ArtifactQuality quality;
	ArtifactType type;

	public Artifact(int level, ArtifactQuality quality) {
		this.level = level;
		this.quality = quality;
	}

	public int getAtkModifier() {
		return atkModifier;
	}

	public int getDefModifier() {
		return defModifier;
	}

	public int getHPModifier() {
		return HPModifier;
	}

	public ArtifactType getType() {
		return type;
	}

	public int getLevel() {
		return level;
	}

	public ArtifactQuality getQuality() {
		return quality;
	}

	public boolean isWorstThan(Artifact artifact) {
		if (artifact.getAtkModifier() > getAtkModifier()) {
			return true;
		}
		if (artifact.getDefModifier() > getDefModifier()) {
			return true;
		}
		if (artifact.getHPModifier() > getHPModifier()) {
			return true;
		}
		return false;
	}

	public String toString() {
		if (level == 0) {
			return "empty ";
		}
		return quality + " " + type + " (level: " + level + ") ";
	}

	public String getDescription() {
		return toString() + getStats();
	}

	abstract public String getStats();
}
