package com.java42.swingy.model.vilain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class VilainFactoryTest {

	@ParameterizedTest(name = "factory provide {0} vilains with min level {1}")
	@CsvSource({ "30, 1" })
	void testGetVilains(int nb, int level) {
		List<Vilain> vilains = VilainFactory.getVilains(nb, level);
		assertEquals(vilains.size(), nb + nb / 20);
		int minlevel = level + 1;
		for (Vilain vilain : vilains) {
			if (vilain.getLevel() < minlevel) {
				minlevel = vilain.getLevel();
			}
		}
		assertEquals(level, minlevel);
	}
}
