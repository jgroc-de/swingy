package com.java42.swingy.view;

import com.java42.swingy.view.cli.CliViewAdaptater;
import com.java42.swingy.view.gui.GuiViewAdaptater;

public class ViewFactory {
	public static View getView(ViewType viewType) {
		if (viewType == ViewType.CLI) {
			return new CliViewAdaptater();
		}
		return new GuiViewAdaptater();
	}
}
