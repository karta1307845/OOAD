package mode;

import java.awt.Robot;
import java.awt.event.MouseEvent;

import model.CanvasModel;
import object.ShapeObject;

public class SelectMode extends Mode{
	
	public SelectMode(CanvasModel canvas, Robot robot) {
		super(canvas, robot);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		ShapeObject selectedObj = getClickedShapeObject(e);
		canvas.unSelectAllObjects();
		if (selectedObj != null) {
			canvas.selectObject(selectedObj);
		}
	}
}
