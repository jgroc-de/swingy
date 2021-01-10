package com.java42.swingy.lib.save;

import java.util.ArrayList;

import com.java42.swingy.model.hero.Hero;

public class NullSave extends Save {
	public NullSave() {
		heroes = new ArrayList<Hero>();
	}

	public void saveHero(Hero hero) {
		if (hero != null && heroes.contains(hero) == false) {
			heroes.add(hero);
		}
	}

	public void deleteHero(Hero hero) {
		heroes.remove(hero);
	}
}
