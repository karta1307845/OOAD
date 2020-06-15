package mode;

import java.awt.Robot;

import model.CanvasModel;
import model.Location;
import object.ClassObject;

public class ClassMode extends CreateBasicObjectMode{

	public ClassMode(CanvasModel canvas, Robot robot) {
		super(canvas, robot);
	}

	@Override
	protected void createObject(Location point) {
		canvas.addObject(new ClassObject(point));
	}

}
