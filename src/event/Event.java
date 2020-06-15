package event;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.MouseEvent;

import model.Location;
import model.UML_Editor;
import object.BasicObject;
import object.ShapeObject;
import object.UML_Object;

public abstract class Event {
	protected UML_Editor editor;
	protected Robot robot;
	protected boolean precondition;

	public Event(UML_Editor editor, Robot robot) {
		this.editor = editor;
		this.robot = robot;
		precondition = false;
	}

	public abstract void press(MouseEvent e);

	public abstract void drag(MouseEvent e);

	public void release(MouseEvent e) {
		reset();
	}

	protected void reset() {
		precondition = false;
	}

	protected BasicObject getClickedBasicObject(MouseEvent e) {
		if (!robot.getPixelColor(e.getXOnScreen(), e.getYOnScreen()).equals(Color.white)) {
			UML_Object[] objects = editor.getSortedObject();
			Location point = new Location(e.getX(), e.getY());

			for (int i = objects.length - 1; i >= 0; i--) {
				UML_Object obj = objects[i];
				if (obj instanceof BasicObject) {
					if (((BasicObject) obj).isClicked(point)) {
						return (BasicObject) obj;
					}
				}
			}
		}
		return null;
	}

	protected ShapeObject getClickedShapeObject(MouseEvent e) {
		UML_Object[] objects = editor.getSortedObject();
		Location point = new Location(e.getX(), e.getY());

		for (int i = objects.length - 1; i >= 0; i--) {
			UML_Object obj = objects[i];
			if (obj instanceof ShapeObject) {
				if (((ShapeObject) obj).isClicked(point)) {
					return (ShapeObject) obj;
				}
			}
		}
		return null;
	}
}
