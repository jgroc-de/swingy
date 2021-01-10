package com.java42.swingy.model.hero;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WarriorTest {

	Hero hero;

	@BeforeEach
	public void setUp() {
		hero = new Warior(0, "test");
	}

	@ParameterizedTest(name = "{0} attack at level {1}")
	@CsvSource({ "2, 1" })
	void testHeroAttack(int atk, int level) {
		assertEquals(atk, hero.getAttack());
	}

	@ParameterizedTest(name = "{0} def at level {1}")
	@CsvSource({ "4, 1" })
	void testHeroDef(int def, int level) {
		assertEquals(def, hero.getDefense());
	}

	@ParameterizedTest(name = "{0} HP at level {1}")
	@CsvSource({ "12, 1" })
	void testHeroHP(int HP, int level) {
		assertEquals(HP, hero.getHP());
	}

}
