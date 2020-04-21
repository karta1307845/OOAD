package view;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.UML_Editor;

public class GUI {
	private JFrame frame;
	private JPanel canvas;
	private Toolbar toolbar;
	private Menu menu;

	public GUI(UML_Editor editor) throws AWTException {
		frame = new JFrame();
		canvas = new Canvas(editor);
		toolbar = new Toolbar(editor);
		menu = new Menu(editor);

		initialize();
	}

	private void initialize() {
		frame.setBackground(Color.black);
		frame.getContentPane().setLayout(new GridBagLayout());

		GridBagConstraints c1 = new GridBagConstraints(0, 0, 10, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
		frame.getContentPane().add(menu.getBar(), c1);

		GridBagConstraints c2 = new GridBagConstraints(0, 1, 1, 10, 0, 0, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(3, 3, 3, 3), 0, 0);
		frame.getContentPane().add(toolbar.getBar(), c2);

		GridBagConstraints c3 = new GridBagConstraints(1, 1, 9, 10, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
		frame.getContentPane().add(canvas, c3);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("UML Editor");
		frame.setSize(900, 600);
		frame.setVisible(true);

	}
}
