package event;

import java.awt.Robot;
import java.awt.event.MouseEvent;

import model.BasicObject;
import model.Location;
import model.Rectangle;
import model.UML_Editor;
import model.UML_Object;

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
			rec = new Rectangle(start, start);
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
			UML_Object[] selectedObjects = rec.selectAllObjects(editor.getSortedObject());
			if (selectedObjects.length > 0) {
				for (UML_Object i : selectedObjects) {
					editor.selectObject(i);
				}
			}
			editor.removeObject(rec);
		}
		reset();
	}

	protected void reset() {
		super.reset();
		rec = null;
		start = null;
	}

}
