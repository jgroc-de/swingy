package com.java42.swingy.view;

public enum GameMessages {
	INTRO("Swingy"), ENDING("The END"), GLHF("GL&HF WITH THIS HERO"), CHOOSE("CHOOSE OR CREATE A HERO FIRST"),
	EMPTYLIST("Hero list is empty for now"), NUMBER("CHOOSE A NUMBER:"), HERO("CHOOSE YOUR HERO"), NAME("ENTER A NAME"),
	CLASS("CHOOSE A CLASS FOR YOUR HERO:"), DIRECTION("SELECT A DIRECTION:"), FACINGVILAIN("You are facing a vilain: "),
	RUN("RUN"), FIGHT("FIGHT");

	String value;

	private GameMessages(String value) {
		this.value = value;
	}

	public String toString() {
		return this.value;
	}

}
