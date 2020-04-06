import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class GUI {
	private JFrame frame;
	private Canvas canvas;
	private Toolbar toolbar;
	private Menu menu;

	GUI() {
		frame = new JFrame();
		canvas = new Canvas();
		menu = new Menu();
		toolbar = new Toolbar();

		initialize();
	}

	private void initialize() {
		frame.getContentPane().setLayout(new GridBagLayout());

		GridBagConstraints c1 = new GridBagConstraints(0, 0, 10, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
		frame.getContentPane().add(menu, c1);
		
		GridBagConstraints c2 = new GridBagConstraints(0, 1, 1, 10, 0, 0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
		frame.getContentPane().add(toolbar, c2);
		
		GridBagConstraints c3 = new GridBagConstraints(1, 1, 9, 10, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
		frame.getContentPane().add(canvas, c3);

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("UML Editor");
		frame.setSize(900, 600);
		frame.setVisible(true);

	}
}
