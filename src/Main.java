import java.awt.AWTException;

import model.UML_Editor;
import view.GUI;

public class Main {

	public static void main(String[] args) throws AWTException {
		UML_Editor editor = new UML_Editor();
		GUI window = new GUI(editor);
	}

}
