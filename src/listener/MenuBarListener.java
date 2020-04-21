package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.CompositeObject;
import model.UML_Editor;
import model.UML_Object;
import view.MenuBar;

public class MenuBarListener implements ActionListener {
	private UML_Editor editor;
	private MenuBar menu;
	private JPanel canvas;

	public MenuBarListener(UML_Editor editor, MenuBar menu, JPanel canvas) {
		this.editor = editor;
		this.menu = menu;
		this.canvas = canvas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int mode = editor.getMode();
		String action = e.getActionCommand();

		switch (mode) {
		case 0:
			if (action.equals("Group") && editor.countSelectedObjects() > 1) {
				UML_Object[] selectedObjects = editor.getSelectedObjects();
				for (UML_Object i : selectedObjects) {
					editor.removeObject(i);
				}
				UML_Object obj = new CompositeObject(selectedObjects);
				editor.addObject(obj);
				canvas.repaint();
			}
			if (action.equals("UnGroup") && editor.countSelectedObjects() == 1) {
				UML_Object[] selectedObjects = editor.getSelectedObjects();
				UML_Object obj = selectedObjects[0];
				if (obj instanceof CompositeObject) {
					UML_Object[] elements = ((CompositeObject) obj).getElements();
					editor.removeObject(obj);
					for (UML_Object i : elements) {
						editor.addObject(i);
					}
					canvas.repaint();
				}
			}
			break;
		}
	}

}
