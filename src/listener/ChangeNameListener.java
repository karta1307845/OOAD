package listener;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import object.UML_Object;
import view.ToolBar;

public class ChangeNameListener extends MenuItemListener{

	public ChangeNameListener(JPanel canvas, ToolBar toolbar) {
		super(canvas, toolbar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (model.countSelectedObjects() == 1) {
			UML_Object obj = model.getSelectedObjects()[0];
			if (obj.isBasicObject()) {
				String input = JOptionPane.showInputDialog("物件的新名稱");
				if (input != null) {
					obj.setName(input);
					canvas.repaint();
				}
			}
		}
	}
}
