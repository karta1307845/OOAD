package event;

import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import model.ConnectionLine;
import model.Location;
import model.ShapeObject;
import model.UML_Editor;
import model.UML_Object;

public class MoveEvent extends Event {
	private UML_Object moveObj;
	private Location start;

	public MoveEvent(UML_Editor editor, Robot robot) {
		super(editor, robot);
	}

	@Override
	public void press(MouseEvent e) {
		Location point = new Location(e.getX(), e.getY());
		UML_Object[] objects = editor.getSortedObject();

		for (UML_Object i : objects) {
			if (i instanceof ShapeObject) {
				if (((ShapeObject) i).isClicked(point)) {
					moveObj = i;
					start = point;
					precondition = true;
				}
			}
		}
	}

	@Override
	public void drag(MouseEvent e) {
		Location point = new Location(e.getX(), e.getY());
		if (precondition) {
			int deltaX = point.getX() - start.getX();
			int deltaY = point.getY() - start.getY();
			start = start.move(deltaX, deltaY);
			moveObj.move(deltaX, deltaY);

			ConnectionLine[] lines = getConnectionLines();
			for (ConnectionLine i : lines) {
				if (moveObj.equals(i.getStartObj())) {
					i.moveStart(deltaX, deltaY);
				}
				if (moveObj.equals(i.getEndObj())) {
					i.moveEnd(deltaX, deltaY);
				}
			}
		}
	}

	@Override
	public void release(MouseEvent e) {
		precondition = false;
	}

	@Override
	protected void reset() {
		super.reset();
		moveObj = null;
		start = null;
	}

	private ConnectionLine[] getConnectionLines() {
		List<ConnectionLine> list = new ArrayList<ConnectionLine>();
		UML_Object[] objects = editor.getSortedObject();

		for (UML_Object i : objects) {
			if (i instanceof ConnectionLine) {
				ConnectionLine line = (ConnectionLine) i;
				if (moveObj.equals(line.getStartObj()) || moveObj.equals(line.getEndObj())) {
					list.add(line);
				}
			}
		}

		ConnectionLine[] result = new ConnectionLine[list.size()];
		result = list.toArray(result);
		return result;

	}
}
