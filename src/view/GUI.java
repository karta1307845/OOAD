package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class GUI extends JFrame {
	private JPanel canvas;
	private ToolBar toolbar;
	private JMenuBar menu;

	public GUI(){
		toolbar = new ToolBar();
		canvas = new Canvas();
		menu = new MenuBar(canvas, toolbar);

		initialize();
	}

	private void initialize() {
		setBackground(Color.black);
		getContentPane().setLayout(new GridBagLayout());

		GridBagConstraints c1 = new GridBagConstraints(0, 0, 10, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
		getContentPane().add(menu, c1);

		GridBagConstraints c2 = new GridBagConstraints(0, 1, 1, 10, 0, 0, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(3, 3, 3, 3), 0, 0);
		getContentPane().add(toolbar, c2);

		GridBagConstraints c3 = new GridBagConstraints(1, 1, 9, 10, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
		getContentPane().add(canvas, c3);
	}
}
