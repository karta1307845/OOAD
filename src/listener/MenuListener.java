package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CompositeObject;
import model.UML_Editor;
import model.UML_Object;
import view.Menu;

public class MenuListener implements ActionListener {
	private UML_Editor editor;
	private Menu menu;

	public MenuListener(UML_Editor editor, Menu menu) {
		this.editor = editor;
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int mode = editor.getMode();
		String action = e.getActionCommand();

		switch (mode) {
		case 1:
			if (action.equals("Group") && editor.countSelectedObjects() > 1) {
				UML_Object obj = new CompositeObject(editor.getSelectedObjects());
				editor.addObject(obj);
			}
			break;
		}
	}

}
