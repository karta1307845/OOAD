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

public class ToolBar {
	private UML_Editor editor;
	private JPanel bar;
	private List<JButton> buttonList;
	private final int toolNum = 6;

	ToolBar(UML_Editor editor) {
		this.editor = editor;
		bar = new JPanel();
		buttonList = new ArrayList<JButton>();

		initialize();
	}

	private void initialize() {
		bar.setLayout(new GridLayout(toolNum, 1, 10, 10));

		for (int i = 0; i < toolNum; i++) {
			Icon icon = new ImageIcon("images/tool" + i + ".png");
			Icon selectedIcon = new ImageIcon("images/tool" + i + "_selected.png");

			JButton button = new JButton(icon);
			button.setSelectedIcon(selectedIcon);
			button.setPreferredSize(new Dimension(50, 50));
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			button.addActionListener(new ToolBarListener(this));

			buttonList.add(button);
			bar.add(button);
		}
	}

	JPanel getBar() {
		return bar;
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

	public UML_Editor getEditor() {
		return editor;
	}
}
