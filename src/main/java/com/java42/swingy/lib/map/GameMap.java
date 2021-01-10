package com.java42.swingy.lib.map;

import java.util.List;

import com.java42.swingy.model.LivingCreature;
import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.vilain.Vilain;

public interface GameMap {
	public int getMapSize(int level);

	public boolean isOutOfMap(int level, int X, int Y);

	public void setInitialMapPosition(Hero hero, int size);

	public int getNbOfVilains(int size);

	public void setVilainsPosition(List<Vilain> vilains, int size);

	public boolean isLivingPosition(LivingCreature livingCreature, int y, int x);

	public boolean isVilainPosition(List<Vilain> vilains, int y, int x);

	public Vilain getVilainFromPosition(List<Vilain> vilains, int X, int Y) throws Exception;
}
