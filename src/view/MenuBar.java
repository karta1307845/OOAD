package view;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import listener.GroupListener;
import listener.MenuBarListener;

public class MenuBar extends JMenuBar {
	private JMenu fileMenu;
	private JMenu editMenu;

	MenuBar(JPanel canvas, ToolBar toolbar) {
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");

		initialize(canvas, toolbar);
	}

	private void initialize(JPanel canvas, ToolBar toolbar) {
		setBackground(new Color(0xDCDCDC));

		JMenuItem groupItem = new JMenuItem("Group");
		groupItem.addActionListener(new GroupListener(canvas, toolbar));
		groupItem.setActionCommand("Group");

		JMenuItem unGroupItem = new JMenuItem("UnGroup");
		unGroupItem.addActionListener(new MenuBarListener(canvas));
		unGroupItem.setActionCommand("UnGroup");

		JMenuItem changeNameItem = new JMenuItem("Change Object Name");
		changeNameItem.addActionListener(new MenuBarListener(canvas));
		changeNameItem.setActionCommand("ChangeName");

		editMenu.add(groupItem);
		editMenu.add(unGroupItem);
		editMenu.addSeparator();
		editMenu.add(changeNameItem);

		add(fileMenu);
		add(editMenu);
	}
}
