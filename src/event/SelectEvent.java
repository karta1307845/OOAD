package event;

import java.awt.Robot;
import java.awt.event.MouseEvent;

import model.ShapeObject;
import model.UML_Editor;

public class SelectEvent extends Event {

	public SelectEvent(UML_Editor editor, Robot robot) {
		super(editor, robot);
	}

	@Override
	public void press(MouseEvent e) {
		ShapeObject selectedObj = getClickedShapeObject(e);
		editor.unSelectAllObjects();
		if (selectedObj != null) {
			editor.selectObject(selectedObj);
		}
	}

	@Override
	public void drag(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
