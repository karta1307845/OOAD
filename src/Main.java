import java.awt.AWTException;

import javax.swing.JFrame;

import model.UML_Editor;
import view.GUI;

public class Main {

	public static void main(String[] args) throws AWTException {
		UML_Editor editor = new UML_Editor();
		GUI window = new GUI(editor);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("UML Editor");
		window.setSize(900, 600);
		window.setVisible(true);
	}

}
