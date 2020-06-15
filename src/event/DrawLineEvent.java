package event;

import java.awt.Robot;
import java.awt.event.MouseEvent;

import model.Location;
import model.UML_Editor;
import object.AssociationLine;
import object.BasicObject;
import object.CompositionLine;
import object.ConnectionLine;
import object.GeneralizationLine;

public class DrawLineEvent extends Event {
	private BasicObject startObj;
	private ConnectionLine line;
	private Location start;
	private int mode;

	public DrawLineEvent(UML_Editor editor, Robot robot, int mode) {
		super(editor, robot);
		this.mode = mode;
	}

	@Override
	public void press(MouseEvent e) {
		Location point = new Location(e.getX(), e.getY());
		startObj = getClickedBasicObject(e);
		if (startObj != null) {
			start = startObj.getMappingPort(point);
			precondition = true;
		}
	}

	@Override
	public void drag(MouseEvent e) {
		if (precondition) {
			if (line != null) {
				editor.removeObject(line);
			}
			Location point = new Location(e.getX(), e.getY());

			switch (mode) {
			case 1:
				line = new AssociationLine(startObj, start, null, point);
				break;
			case 2:
				line = new GeneralizationLine(startObj, start, null, point);
				break;
			case 3:
				line = new CompositionLine(startObj, start, null, point);
				break;
			}
			editor.addObject(line);
		}
	}

	@Override
	public void release(MouseEvent e) {
		if (precondition) {
			Location point = new Location(e.getX(), e.getY());
			BasicObject endObj = getClickedBasicObject(e);
			editor.removeObject(line);
			if (endObj != null && !endObj.equals(startObj)) {
				switch (mode) {
				case 1:
					line = new AssociationLine(startObj, start, endObj, endObj.getMappingPort(point));
					break;
				case 2:
					line = new GeneralizationLine(startObj, start, endObj, endObj.getMappingPort(point));
					break;
				case 3:
					line = new CompositionLine(startObj, start, endObj, endObj.getMappingPort(point));
					break;
				}
				editor.addObject(line);
			}
		}
		reset();
	}

	@Override
	protected void reset() {
		super.reset();
		startObj = null;
		line = null;
		start = null;
	}
}
