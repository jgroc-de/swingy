package com.java42.swingy.lib.save;

public class SaveFactory {
	public static HeroDAO getSaveMean(String fileName) {
		try {
			return new FileSave(fileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new NullSave();
		}

	}
}
