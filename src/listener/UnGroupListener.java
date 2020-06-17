package listener;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import object.UML_Object;
import view.ToolBar;

public class UnGroupListener extends MenuItemListener {

	public UnGroupListener(JPanel canvas, ToolBar toolbar) {
		super(canvas, toolbar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (model.countSelectedObjects() == 1) {
			UML_Object obj = model.getSelectedObjects()[0];
			UML_Object[] elements = obj.unGroup();

			if (elements != null) {
				model.removeObject(obj);
				for (UML_Object i : elements) {
					model.addObject(i);
				}
				canvas.repaint();
			}
		}
	}
}
