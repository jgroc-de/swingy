package com.java42.swingy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.java2.swingy.XPManager.XPSwingy;
import com.java42.swingy.heroTypes.HeroType;

class HeroTest {

	private static Hero hero;
	private static XPSwingy XPmanager;

	@BeforeAll
	public static void setUp() {
		hero = new Hero(0, HeroType.MAGE, "lol");
		XPmanager = new XPSwingy();
	}

	@ParameterizedTest(name = "adding {0} to Hero, he has {1} XP remaining and is level {2}")
	@CsvSource({ "100, 100, 1", "1000, 100, 2", "2400, 50, 3", "12850, 50, 5" })
	void testAddXP(int XP, int XPremaining, int level) {
		XPmanager.addXP(hero, XP);
		assertEquals(level, hero.getLevel());
		assertEquals(XPremaining, hero.getXP());
	}

}
