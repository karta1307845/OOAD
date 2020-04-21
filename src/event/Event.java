package event;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.MouseEvent;

import model.BasicObject;
import model.Location;
import model.UML_Editor;
import model.UML_Object;

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

	public abstract void release(MouseEvent e);

	protected void reset() {
		precondition = false;
	}

	protected BasicObject getClickedBasicObject(MouseEvent e) {
		if (!robot.getPixelColor(e.getXOnScreen(), e.getYOnScreen()).equals(Color.white)) {
			UML_Object[] objects = editor.getSortedObject();
			Location point = new Location(e.getX(), e.getY());

			for (UML_Object i : objects) {
				if (i instanceof BasicObject) {
					if (((BasicObject) i).isClicked(point)) {
						return (BasicObject) i;
					}
				}
			}
		}
		return null;
	}
}
