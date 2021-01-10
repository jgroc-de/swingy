package com.java42.swingy.lib.XPManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.hero.Mage;
import com.java42.swingy.model.vilain.Vilain;

class XPSwingyTest {

	XPSwingy manager;

	@BeforeEach
	public void setUpManager() {
		manager = new XPSwingy();
	}

	@ParameterizedTest(name = "{0} xp at level {1} should remain {2}")
	@CsvSource({ "1, 1001, 1", "1, 2451, 2", "0, 2450, 2", "-450, 2000, 2", "1, 4801, 3", "1, 8051, 4" })
	void testComputeRemainingXP(int result, int XP, int level) {
		assertEquals(result, manager.computeRemainingXP(XP, level));
	}

	@ParameterizedTest(name = "{0} xp at level {1} can level up")
	@CsvSource({ "1000, 1", "2450, 2", "4800, 3", "8051, 4" })
	void testCanLevelUP(int XP, int level) {
		assertTrue(manager.canLevelUp(XP, level));
	}

	@ParameterizedTest(name = "{0} xp at level {1} can NOT level up")
	@CsvSource({ "2000, 2" })
	void testCanNotLevelUP(int XP, int level) {
		assertFalse(manager.canLevelUp(XP, level));
	}

	@ParameterizedTest(name = "vilain level {1} provide {0} XP")
	@CsvSource({ "400, 1", "800, 2", "1200, 3", "1600, 4", "2000, 5" })
	void testGetXp(int xp, int level) {
		Vilain vilain = new Vilain(0);
		vilain.setLevel(level);
		assertEquals(manager.getXP(vilain), xp);
	}

	@ParameterizedTest(name = "vilain level {1}: hero gain right XP")
	@CsvSource({ "1", "2", "3", "4", "5" })
	void testAddXP(int vilainLevel) {
		Hero hero = new Mage(0, "test");
		Vilain vilain = new Vilain(0);
		manager.addXP(hero, vilain);
		assertEquals(manager.getXP(vilain), hero.getXP());

	}

}
