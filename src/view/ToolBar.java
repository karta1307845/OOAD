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
import model.ToolBarModel;
import model.UML_Editor;

public class ToolBar extends JPanel {
	private ToolBarModel model;
	private UML_Editor editor;
	private List<JButton> buttonList;
	private final int toolNum = 6;
	private int pressedButtonIndex;

	ToolBar(UML_Editor editor) {
		model = new ToolBarModel();
		this.editor = editor;
		buttonList = new ArrayList<JButton>();
		pressedButtonIndex = -1;

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
			button.addActionListener(new ToolBarListener(model, this));

			buttonList.add(button);
			add(button);
		}
	}

	public int getButtonIndex(Object button) {
		return buttonList.indexOf(button);
	}

	public void pressButton(int index) {
		pressedButtonIndex = index;
		buttonList.get(index).setSelected(true);
	}

	public void releaseButton(int index) {
		buttonList.get(index).setSelected(false);
	}

	public int getPressedButtonIndex() {
		return pressedButtonIndex;
	}
}
