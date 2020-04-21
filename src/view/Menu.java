package view;
import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Menu {
	private JMenuBar bar;
	private JMenu fileMenu;
	private JMenu editMenu;

	Menu() {
		bar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");

		initialize();
	}

	private void initialize() {
		bar.setBackground(new Color(0xDCDCDC));
		bar.add(fileMenu);
		bar.add(editMenu);
	}

	public JMenuBar getBar() {
		return bar;
	}
}
