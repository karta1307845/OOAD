package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mode.Mode;
import model.CanvasModel;
import model.ToolBarModel;
import object.BasicObject;
import object.CompositeObject;
import object.ConnectionLine;
import object.ShapeObject;
import object.UML_Object;

public class MenuBarListener implements ActionListener {
	private CanvasModel model;
	private ToolBarModel toolbarModel;
	private JPanel canvas;

	public MenuBarListener(JPanel canvas) {
		this.canvas = canvas;
		model = CanvasModel.getInstance();
		toolbarModel = ToolBarModel.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Mode mode = toolbarModel.getMode();
		String action = e.getActionCommand();

		if (mode == 0 && action.equals("Group") && model.countSelectedShapeObjects() > 1) {
			Set<ConnectionLine> lineSet = new HashSet<ConnectionLine>();
			ShapeObject[] selectedObjects = model.getSelectedShapeObjects();

			for (UML_Object i : selectedObjects) {
				model.removeObject(i);
				ConnectionLine[] lines = model.getConnectionLines(i);
				for (ConnectionLine j : lines) {
					lineSet.add(j);
				}
			}

			ConnectionLine[] lineAry = new ConnectionLine[lineSet.size()];
			lineAry = lineSet.toArray(lineAry);
			UML_Object obj = new CompositeObject(selectedObjects);
			model.addObject(obj);

			canvas.repaint();
		}

		if (action.equals("UnGroup") && model.countSelectedObjects() == 1) {
			UML_Object obj = model.getSelectedObjects()[0];
			if (obj instanceof CompositeObject) {
				UML_Object[] elements = ((CompositeObject) obj).getElements();
				model.removeObject(obj);

				for (UML_Object i : elements) {
					model.addObject(i);
				}
				canvas.repaint();
			}
		}

		if (action.equals("ChangeName") && model.countSelectedObjects() == 1) {
			UML_Object obj = model.getSelectedObjects()[0];
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
