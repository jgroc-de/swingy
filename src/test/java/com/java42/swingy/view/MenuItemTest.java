package com.java42.swingy.view;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuItemTest {

	@ParameterizedTest(name = "option {0} is valid")
	@ValueSource(ints = { 1, 2, 3, 4 })
	public void testIsValidItem(int arg) {
		assertTrue(MenuItem.isValidItem(arg));
	}

	@ParameterizedTest(name = "option {0} is NOT valid")
	@ValueSource(ints = { 0, 5, 42 })
	public void testIsNotValidItem(int arg) {
		assertFalse(MenuItem.isValidItem(arg));
	}

}
