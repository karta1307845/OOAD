package mode;

import java.awt.Robot;
import java.awt.event.MouseEvent;

import model.CanvasModel;
import model.Location;

public abstract class CreateBasicObjectMode extends Mode{

	public CreateBasicObjectMode(CanvasModel canvas, Robot robot) {
		super(canvas, robot);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Location point = new Location(e.getX(), e.getY());
		createObject(point);
	}
	
	protected abstract void createObject(Location point);
}
