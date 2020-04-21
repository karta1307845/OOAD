package view;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import listener.MenuListener;
import model.UML_Editor;

public class Menu {
	private UML_Editor editor;
	private JMenuBar bar;
	private JMenu fileMenu;
	private JMenu editMenu;

	Menu(UML_Editor editor) {
		this.editor = editor;
		bar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");

		initialize();
	}

	private void initialize() {
		bar.setBackground(new Color(0xDCDCDC));

		JMenuItem groupItem = new JMenuItem("Group");
		groupItem.addActionListener(new MenuListener(editor, this));
		groupItem.setActionCommand("Group");

		JMenuItem unGroupItem = new JMenuItem("UnGroup");
		unGroupItem.addActionListener(new MenuListener(editor, this));
		unGroupItem.setActionCommand("UnGroup");

		editMenu.add(groupItem);
		editMenu.add(unGroupItem);

		bar.add(fileMenu);
		bar.add(editMenu);
	}

	public JMenuBar getBar() {
		return bar;
	}
}
