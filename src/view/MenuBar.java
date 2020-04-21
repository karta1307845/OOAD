package view;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import listener.MenuBarListener;
import model.UML_Editor;

public class MenuBar {
	private UML_Editor editor;
	private JMenuBar bar;
	private JMenu fileMenu;
	private JMenu editMenu;

	MenuBar(UML_Editor editor, JPanel canvas) {
		this.editor = editor;
		bar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");

		initialize(canvas);
	}

	private void initialize(JPanel canvas) {
		bar.setBackground(new Color(0xDCDCDC));

		JMenuItem groupItem = new JMenuItem("Group");
		groupItem.addActionListener(new MenuBarListener(editor, this, canvas));
		groupItem.setActionCommand("Group");

		JMenuItem unGroupItem = new JMenuItem("UnGroup");
		unGroupItem.addActionListener(new MenuBarListener(editor, this, canvas));
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
