package event;

import java.awt.Robot;
import java.awt.event.MouseEvent;

import model.BasicObject;
import model.Location;
import model.Rectangle;
import model.ShapeObject;
import model.UML_Editor;

public class DrawRectangleEvent extends Event {
	private Rectangle rec;
	private Location start;

	public DrawRectangleEvent(UML_Editor editor, Robot robot) {
		super(editor, robot);
	}

	@Override
	public void press(MouseEvent e) {
		BasicObject obj = getClickedBasicObject(e);
		if (obj == null) {
			start = new Location(e.getX(), e.getY());
			precondition = true;
		}
	}

	@Override
	public void drag(MouseEvent e) {
		if (precondition) {
			if (rec != null) {
				editor.removeObject(rec);
			}
			Location point = new Location(e.getX(), e.getY());
			rec = new Rectangle(start, point);
			editor.addObject(rec);
		}
	}

	@Override
	public void release(MouseEvent e) {
		if (precondition) {
			editor.unSelectAllObjects();
			ShapeObject[] selectedObjects = rec.selectAllShapeObjects(editor.getSortedObject());
			if (selectedObjects.length > 0) {
				for (ShapeObject i : selectedObjects) {
					editor.selectObject(i);
				}
			}
			editor.removeObject(rec);
		}
	}

	protected void reset() {
		super.reset();
		rec = null;
		start = null;
	}

}
