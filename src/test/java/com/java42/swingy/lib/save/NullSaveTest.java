package com.java42.swingy.lib.save;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.hero.Mage;

public class NullSaveTest {
	Save save;

	@BeforeEach
	public void setSave() {
		save = new NullSave();
	}

	@ParameterizedTest(name = "after id {0}, id is {1}")
	@CsvSource({ "9, 10", "14, 15" })
	public void testGetNextId(int firstID, int nextId) {
		Hero hero = new Mage(firstID, "test");
		save.saveHero(hero);
		assertEquals(nextId, save.getNextId());
	}

}
