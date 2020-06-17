package listener;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import object.CompositeObject;
import object.UML_Object;
import view.ToolBar;

public class GroupListener extends MenuItemListener {

	public GroupListener(JPanel canvas, ToolBar toolbar) {
		super(canvas, toolbar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int mode = toolbar.getPressedButtonIndex();

		if (mode == 0 && model.countSelectedObjects() > 1) {
			UML_Object[] selectedObjects = model.getSelectedObjects();
			
			for (UML_Object i : selectedObjects) {
				model.removeObject(i);
			}
			
			UML_Object obj = new CompositeObject();
			obj.group(selectedObjects);
			model.addObject(obj);

			canvas.repaint();
		}
	}
}
