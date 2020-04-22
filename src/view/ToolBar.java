package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import listener.ToolBarListener;
import model.UML_Editor;

public class ToolBar extends JPanel {
	private UML_Editor editor;
	private List<JButton> buttonList;
	private final int toolNum = 6;

	ToolBar(UML_Editor editor) {
		this.editor = editor;
		buttonList = new ArrayList<JButton>();

		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(toolNum, 1, 10, 10));

		for (int i = 0; i < toolNum; i++) {
			Icon icon = new ImageIcon("images/tool" + i + ".png");
			Icon selectedIcon = new ImageIcon("images/tool" + i + "_selected.png");

			JButton button = new JButton(icon);
			button.setSelectedIcon(selectedIcon);
			button.setPreferredSize(new Dimension(50, 50));
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			button.addActionListener(new ToolBarListener(editor, this));

			buttonList.add(button);
			add(button);
		}
	}

	public int getButtonIndex(Object button) {
		return buttonList.indexOf(button);
	}

	public void pressButton(int index) {
		buttonList.get(index).setSelected(true);
	}

	public void releaseButton(int index) {
		buttonList.get(index).setSelected(false);
	}
}
