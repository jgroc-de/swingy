package com.java42.swingy.model.vilain;

import java.util.ArrayList;
import java.util.List;

public class VilainFactory {
	public static Vilain createVilain(VilainType vilainClass, int id, int level) {
		Vilain vilain;
		switch (vilainClass) {
		case TROLL:
			vilain = new Troll(id);
			break;
		case MOBLIN:
			vilain = new Moblin(id);
			break;
		case SKELETTON:
			vilain = new Skeletton(id);
			break;
		default:
			vilain = new Troll(id);
		}
		vilain.setLevel(level);

		return vilain;
	}

	public static List<Vilain> getVilains(int nb, int minLevel) {
		List<Vilain> vilains = new ArrayList<Vilain>();
		VilainType type;
		int nbBoss = nb / 20;

		while (nb-- > 0) {
			type = VilainType.getRandomType();
			vilains.add(createVilain(type, nb, (int) (Math.random() * (minLevel + 1) + minLevel)));
		}
		while (nbBoss-- > 0) {
			vilains.add(createVilain(VilainType.getRandomType(), nb, minLevel * 3));
		}

		return vilains;
	}
}
