package com.java42.swingy.view;

public enum ViewType {
	CLI(0), GUI(1);

	int value;

	ViewType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
