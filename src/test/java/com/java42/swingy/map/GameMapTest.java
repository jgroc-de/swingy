package com.java42.swingy.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameMapTest {
	GameMap gameMap;

	@BeforeEach
	public void setMap() {
		gameMap = new GameMap();
	}

	@ParameterizedTest(name = "at level {1} size is {0}")
	@CsvSource({ "9, 1", "14, 2", "39, 7" })
	public void testMapSize(int result, int level) {
		assertEquals(result, gameMap.getMapSize(level));
	}

	@ParameterizedTest(name = "at position ({1}, {2} for level {0}, is victory)")
	@CsvSource({ "1, 1, 2", "1, 0, 2", "1, 4, -1", "1, 10, 4", "1, 2, 43", "2, 3, 1", "1, 9, 2", "1, 2, 9" })
	public void testisOutOfMap(int level, int X, int Y) {
		assertTrue(gameMap.isOutOfMap(level, X, Y));
	}
}
