package mode;

import java.awt.Robot;
import java.awt.event.MouseEvent;

import model.ShapeObject;
import model.UML_Editor;

public class SelectMode extends Mode{
	
	public SelectMode() {
		
	}
	
	public SelectMode(UML_Editor editor, Robot robot) {
		super(editor, robot);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		ShapeObject selectedObj = getClickedShapeObject(e);
		editor.unSelectAllObjects();
		if (selectedObj != null) {
			editor.selectObject(selectedObj);
		}
	}
}
