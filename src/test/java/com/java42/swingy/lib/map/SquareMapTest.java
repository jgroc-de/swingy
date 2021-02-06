package com.java42.swingy.lib.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.java42.swingy.model.vilain.Vilain;

public class SquareMapTest {
	SquareMap gameMap;

	@BeforeEach
	public void setMap() {
		gameMap = new SquareMap();
	}

	@ParameterizedTest(name = "at level {1} size is {0}")
	@CsvSource({ "9, 1", "14, 2", "39, 7" })
	public void testMapSize(int result, int level) {
		gameMap.setMapSize(level);
		assertEquals(result, gameMap.getMapSize());
	}

	@ParameterizedTest(name = "at position ({1}, {2} for level {0}, is victory)")
	@CsvSource({ "1, 1, 2", "1, 0, 2", "1, 4, -1", "1, 10, 4", "1, 2, 43", "2, 3, 1", "1, 9, 2", "1, 2, 9" })
	public void testisOutOfMap(int level, int X, int Y) {
		gameMap.setMapSize(level);
		assertTrue(gameMap.isOutOfMap(X, Y));
	}

	@ParameterizedTest(name = "for map of size {0} there are {1} vilains")
	@CsvSource({ "1, 20", "2, 49", "7, 380" })
	public void testGetNbOfVilains(int level, int nb) {
		gameMap.setMapSize(level);
		assertEquals(gameMap.getNbOfVilains(), nb);
	}

	@ParameterizedTest(name = "vilain is at position ({0}, {1})")
	@CsvSource({ "2, 2", "14, 10" })
	public void testisLivingPosition(int X, int Y) {
		Vilain vilain = new Vilain(0);
		vilain.setX(X);
		vilain.setY(Y);
		assertTrue(gameMap.isLivingPosition(vilain, Y, X));
	}

	@ParameterizedTest(name = "im on a vilain position ({0}, {1})")
	@CsvSource({ "2, 2", "14, 10" })
	public void testIsVilainsPosition(int X, int Y) {
		Vilain vilain1 = new Vilain(0);
		vilain1.setX(X - 1);
		vilain1.setY(Y + 1);
		Vilain vilain2 = new Vilain(0);
		vilain2.setX(X);
		vilain2.setY(Y);
		Vilain vilain3 = new Vilain(0);
		vilain3.setX(X);
		vilain3.setY(Y);
		List<Vilain> vilains = new ArrayList<Vilain>();
		vilains.add(vilain1);
		vilains.add(vilain2);
		vilains.add(vilain3);
		gameMap.setVilains(vilains);
		assertTrue(gameMap.isVilainPosition(Y, X));
	}

	@ParameterizedTest(name = "get right vilain of position ({0}, {1})")
	@CsvSource({ "2, 2", "14, 10" })
	public void testGetVilainPosition(int X, int Y) {
		Vilain vilain1 = new Vilain(0);
		vilain1.setX(X - 1);
		vilain1.setY(Y + 1);
		Vilain vilain2 = new Vilain(0);
		vilain2.setX(X);
		vilain2.setY(Y);
		Vilain vilain3 = new Vilain(0);
		vilain3.setX(X);
		vilain3.setY(Y);
		List<Vilain> vilains = new ArrayList<Vilain>();
		vilains.add(vilain1);
		vilains.add(vilain2);
		vilains.add(vilain3);
		gameMap.setVilains(vilains);
		try {
			assertEquals(gameMap.getVilainFromPosition(Y, X).getX(), X);
			assertEquals(gameMap.getVilainFromPosition(Y, X).getY(), Y);
		} catch (Exception e) {

		}
	}
}
