package com.java42.swingy.map;

public enum Direction {
	NORTH(1, "North", 0, -1), EAST(2, "East", 1, 0), SOUTH(3, "South", 0, 1), WEST(4, "West", -1, 0);

	int value;
	String label;
	int X;
	int Y;

	public int getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

	Direction(int value, String label, int X, int Y) {
		this.value = value;
		this.label = label;
		this.X = X;
		this.Y = Y;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}
}
