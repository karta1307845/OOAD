package mode;

import java.awt.Robot;
import java.awt.event.MouseEvent;

import model.CanvasModel;
import model.Location;
import object.BasicObject;
import object.ConnectionLine;
import object.Port;

public abstract class DrawLineMode extends Mode {
	protected BasicObject startObj;
	protected ConnectionLine line;
	protected Port start;

	public DrawLineMode(CanvasModel canvas, Robot robot) {
		super(canvas, robot);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Location point = new Location(e.getX(), e.getY());
		startObj = getClickedBasicObject(e);
		if (startObj != null) {
			start = startObj.getMappingPort(point);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (startObj != null) {
			if (line != null) {
				canvas.removeObject(line);
			}
			Location point = new Location(e.getX(), e.getY());
			line = createLine(start, new Port(point, null));
			canvas.addObject(line);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (startObj != null) {
			Location point = new Location(e.getX(), e.getY());
			BasicObject endObj = getClickedBasicObject(e);
			canvas.removeObject(line);
			if (endObj != null && !endObj.equals(startObj)) {
				line = createLine(start, endObj.getMappingPort(point));
				canvas.addObject(line);
			}
		}
		reset();
	}

	protected void reset() {
		startObj = null;
		line = null;
		start = null;
	}

	protected abstract ConnectionLine createLine(Port start, Port end);
}
