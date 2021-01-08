package com.java42.swingy.save;

import java.util.ArrayList;
import java.util.List;

import com.java42.swingy.model.Hero;

public class NullSave implements Save {
	List<Hero> heroes;

	public NullSave() {
		heroes = new ArrayList<Hero>();
	}

	@Override
	public void saveHero(Hero hero) {
		heroes.add(hero);
	}

	@Override
	public void deleteHero(Hero hero) {
		heroes.remove(hero);
	}

	@Override
	public int getNextId() {
		return 0;
	}

	@Override
	public List<Hero> getAllHeroes() {
		return heroes;
	}
}
