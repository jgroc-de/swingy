package com.java42.swingy.view;

public enum MenuItem {
	HERO_CREATION(1, "Create Hero"), HERO_SELECTION(2, "Select Hero"), PLAY(3, "Play"), QUIT(4, "Quit");

	public int getValue() {
		return value;
	}

	public String getLabel(boolean heroIsSet) {
		if (label == "Play" && heroIsSet) {
			return "Continue";
		}
		return label;
	}

	int value;
	String label;

	MenuItem(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public static boolean isValidItem(int value) {
		for (MenuItem item : MenuItem.values()) {
			if (item.getValue() == value) {
				return true;
			}
		}

		return false;
	}

	public static MenuItem getItem(int value) {
		for (MenuItem item : MenuItem.values()) {
			if (item.getValue() == value) {
				return item;
			}
		}

		return QUIT;
	}
}
