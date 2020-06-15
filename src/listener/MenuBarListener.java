package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.UML_Editor;
import object.BasicObject;
import object.CompositeObject;
import object.ConnectionLine;
import object.ShapeObject;
import object.UML_Object;
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

		if (mode == 0 && action.equals("Group") && editor.countSelectedShapeObjects() > 1) {
			Set<ConnectionLine> lineSet = new HashSet<ConnectionLine>();
			ShapeObject[] selectedObjects = editor.getSelectedShapeObjects();

			for (UML_Object i : selectedObjects) {
				editor.removeObject(i);
				ConnectionLine[] lines = editor.getConnectionLines(i);
				for (ConnectionLine j : lines) {
					lineSet.add(j);
				}
			}

			ConnectionLine[] lineAry = new ConnectionLine[lineSet.size()];
			lineAry = lineSet.toArray(lineAry);
			UML_Object obj = new CompositeObject(selectedObjects);
			editor.addObject(obj);

			canvas.repaint();
		}

		if (action.equals("UnGroup") && editor.countSelectedObjects() == 1) {
			UML_Object obj = editor.getSelectedObjects()[0];
			if (obj instanceof CompositeObject) {
				UML_Object[] elements = ((CompositeObject) obj).getElements();
				editor.removeObject(obj);

				for (UML_Object i : elements) {
					editor.addObject(i);
				}
				canvas.repaint();
			}
		}

		if (action.equals("ChangeName") && editor.countSelectedObjects() == 1) {
			UML_Object obj = editor.getSelectedObjects()[0];
			if (obj instanceof BasicObject) {
				String input = JOptionPane.showInputDialog("物件的新名稱");
				if (input != null) {
					((BasicObject) obj).setName(input);
					canvas.repaint();
				}
			}
		}
	}

}
