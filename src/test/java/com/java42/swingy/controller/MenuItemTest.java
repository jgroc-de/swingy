package com.java42.swingy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuItemTest {
	@ParameterizedTest(name = "{0} is a valid item")
	@ValueSource(ints = { 1, 2, 3, 4 })
	void testIsValidItem(int value) {
		assertTrue(MenuItem.isValidItem(value));
	}

	@ParameterizedTest(name = "{0} is NOT a valid item")
	@ValueSource(ints = { 0, -1, 5, 99999 })
	void testIsNotValidItem(int value) {
		assertFalse(MenuItem.isValidItem(value));
	}

	@ParameterizedTest(name = "{0} is item {1}")
	@CsvSource({ "HERO_CREATION, 1", "QUIT, 4" })
	void testIsRightItem(MenuItem type, int value) {
		assertEquals(type, MenuItem.getItem(value));
	}

	@ParameterizedTest(name = "{0} is NOT item {1}")
	@CsvSource({ "HERO_CREATION, 0", "QUIT, 1" })
	void testIsNotRightItem(MenuItem type, int value) {
		assertNotEquals(type, MenuItem.getItem(value));
	}
}
