package com.java42.swingy.HeroTypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.java42.swingy.heroTypes.CommonHero;
import com.java42.swingy.heroTypes.Rogue;

class RogueTest {
	CommonHero hero;

	@BeforeEach
	public void setUp() {
		hero = new Rogue();
	}

	@ParameterizedTest(name = "{0} attack at level {1}")
	@CsvSource({ "0, 0", "3, 1", "6, 2" })
	void testHeroAttack(int atk, int level) {
		assertEquals(atk, hero.getAttack(level));
	}

	@ParameterizedTest(name = "{0} def at level {1}")
	@CsvSource({ "0, 0", "1, 1", "2, 2" })
	void testHeroDef(int def, int level) {
		assertEquals(def, hero.getDeffense(level));
	}

	@ParameterizedTest(name = "{0} HP at level {1}")
	@CsvSource({ "8, 0", "12, 1", "16, 2" })
	void testHeroHP(int HP, int level) {
		assertEquals(HP, hero.getHP(level));
	}

}
