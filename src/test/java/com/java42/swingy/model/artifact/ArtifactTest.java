package com.java42.swingy.model.artifact;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ArtifactTest {

	@ParameterizedTest(name = "quality {0} is worst than quality {1}")
	@CsvSource({ "WOOD, IRON", "WOOD, STEEL", "IRON, STEEL" })
	void testIsBetterQuality(ArtifactQuality lowerQ, ArtifactQuality higherQ) {
		Artifact lowerA = new Sword(1, lowerQ);
		Artifact highrA = new Sword(1, higherQ);
		assertTrue(lowerA.isWorstThan(highrA));
	}

	@ParameterizedTest(name = "level {0} is worst than level {1}")
	@CsvSource({ "0, 1", "4, 6" })
	void testIsBetterLevel(int lowerLevel, int higherLevel) {
		Artifact lowerA = new Sword(lowerLevel, ArtifactQuality.WOOD);
		Artifact highrA = new Sword(higherLevel, ArtifactQuality.WOOD);
		assertTrue(lowerA.isWorstThan(highrA));
	}

	@ParameterizedTest(name = "level {0} of quality {1} is worst than level {2} quality {3}")
	@CsvSource({ "0, STEEL, 1, WOOD", "3, WOOD, 2, IRON", "2, WOOD, 1, STEEL", "8, WOOD, 4, STEEL" })
	void testIsBetter(int lvl1, ArtifactQuality q1, int lvl2, ArtifactQuality q2) {
		Artifact lowerA = new Sword(lvl1, q1);
		Artifact highrA = new Sword(lvl2, q2);
		assertTrue(lowerA.isWorstThan(highrA));
	}
}
