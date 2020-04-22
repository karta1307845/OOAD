package view;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import listener.MenuBarListener;
import model.UML_Editor;

public class MenuBar extends JMenuBar {
	private UML_Editor editor;
	private JMenu fileMenu;
	private JMenu editMenu;

	MenuBar(UML_Editor editor, JPanel canvas) {
		this.editor = editor;
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");

		initialize(canvas);
	}

	private void initialize(JPanel canvas) {
		setBackground(new Color(0xDCDCDC));

		JMenuItem groupItem = new JMenuItem("Group");
		groupItem.addActionListener(new MenuBarListener(editor, this, canvas));
		groupItem.setActionCommand("Group");

		JMenuItem unGroupItem = new JMenuItem("UnGroup");
		unGroupItem.addActionListener(new MenuBarListener(editor, this, canvas));
		unGroupItem.setActionCommand("UnGroup");

		JMenuItem changeNameItem = new JMenuItem("Change Object Name");
		changeNameItem.addActionListener(new MenuBarListener(editor, this, canvas));
		changeNameItem.setActionCommand("ChangeName");

		editMenu.add(groupItem);
		editMenu.add(unGroupItem);
		editMenu.addSeparator();
		editMenu.add(changeNameItem);

		add(fileMenu);
		add(editMenu);
	}
}
