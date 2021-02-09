package com.java42.swingy.lib.IO;

import java.util.Scanner;

public class Misc {
	Scanner keyboard;

	public Misc() {
		this.keyboard = new Scanner(System.in);
	}

	public int getNextNumber() {
		while (true) {
			try {
				return keyboard.nextInt();
			} catch (Exception e) {
				println("number required");
				keyboard.nextLine();
			}
		}
	}

	public String nextLine() {
		return keyboard.nextLine();
	}

	public void println(String line) {
		System.out.println(line);
	}
}
