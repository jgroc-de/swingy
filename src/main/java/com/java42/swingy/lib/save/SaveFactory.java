package com.java42.swingy.lib.save;

public class SaveFactory {
	public static HeroDAO getSaveMean(String fileName) {
		try {
			try {
				return new SqlSave();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return new FileSave(fileName);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new NullSave();
		}

	}
}
