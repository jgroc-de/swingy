package com.java42.swingy.lib.save;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.java42.swingy.model.hero.Hero;
import com.java42.swingy.model.hero.HeroFactory;

public class FileSave extends Save {
	String fileName;

	public FileSave(String fileName) throws Exception {
		this.fileName = fileName;
		heroes = new ArrayList<Hero>();
		Path path = Paths.get(fileName);
		try {
			File myObj = new File(fileName);
			if (myObj.exists() == false) {
				myObj.createNewFile();
				if (myObj.canRead() == false) {
					throw new Exception("cant read file");
				}
				if (myObj.canWrite() == false) {
					throw new Exception("cant write in file");
				}
			}
			List<String> heroesLine = Files.readAllLines(path);
			for (String line : heroesLine) {
				Hero hero = HeroFactory.createHeroFromCSV(line.split(","));
				heroes.add(hero);
			}
		} catch (IOException e) {
			throw new Exception("cant read file");
		} catch (Exception e) {
			throw new Exception("cant write in file");
		}
	}

	public void saveHero(Hero hero) {
		if (hero != null && heroes.contains(hero) == false) {
			heroes.add(hero);
		}
		saveHeroes();
	}

	private void saveHeroes() {
		try {
			File myObj = new File(fileName);
			if (myObj.exists() == false) {
				myObj.createNewFile();
			}
			FileWriter myWriter = new FileWriter(fileName);
			String heroesToCsv = "";
			for (Hero hero : heroes) {
				heroesToCsv += hero.toCsv();
			}
			myWriter.write(heroesToCsv);
			myWriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void deleteHero(Hero hero) {
		heroes.remove(hero);
		saveHeroes();
	}
}
