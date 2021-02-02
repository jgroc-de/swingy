package com.java42.swingy.lib.save;

import java.util.List;

import com.java42.swingy.model.hero.Hero;

public abstract class HeroDAO {
	protected List<Hero> heroes;

	abstract public void saveHero(Hero hero);

	abstract public void deleteHero(Hero hero);

	public int getNextId() {
		int heroID = 0;

		try {
			Hero hero = heroes.get(heroes.size() - 1);
			return hero.getID() + 1;
		} catch (IndexOutOfBoundsException e) {
			return heroID;
		}
	}

	public List<Hero> getAllHeroes() {
		return heroes;
	}
}
