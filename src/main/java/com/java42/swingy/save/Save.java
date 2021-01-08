package com.java42.swingy.save;

import java.util.List;

import com.java42.swingy.model.Hero;

public interface Save {
	public List<Hero> getAllHeroes();

	public void saveHero(Hero hero);

	public void deleteHero(Hero hero);

	public int getNextId();
}
