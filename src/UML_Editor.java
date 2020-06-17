
import javax.swing.JFrame;

import view.GUI;

public class UML_Editor {

	public static void main(String[] args) {
		GUI window = new GUI();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("UML Editor");
		window.setSize(900, 600);
		window.setVisible(true);
	}

}
