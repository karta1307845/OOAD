package model;

import mode.Mode;

public class ToolBarModel {
	private static ToolBarModel instance;
	private Mode mode;

	private ToolBarModel() {
	}

	public static ToolBarModel getInstance() {
		if (instance == null) {
			instance = new ToolBarModel();
		}
		return instance;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}
}
