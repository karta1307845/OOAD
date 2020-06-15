package mode;

import java.awt.Robot;

import model.CanvasModel;
import model.Location;
import object.UseCaseObject;

public class UseCaseMode extends CreateBasicObjectMode{

	public UseCaseMode(CanvasModel canvas, Robot robot) {
		super(canvas, robot);
	}

	@Override
	protected void createObject(Location point) {
		canvas.addObject(new UseCaseObject(point));
	}

}
