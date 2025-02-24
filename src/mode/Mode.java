package mode;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.CanvasModel;
import model.Location;
import object.UML_Object;

public class Mode implements MouseListener, MouseMotionListener {
	protected CanvasModel canvas;
	protected Robot robot;

	public Mode(CanvasModel canvas, Robot robot) {
		this.canvas = canvas;
		this.robot = robot;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	protected void reset() {

	}

	protected UML_Object getClickedBasicObject(MouseEvent e) {
		UML_Object obj = getClickedObject(e);
		if (obj != null && !robot.getPixelColor(e.getXOnScreen(), e.getYOnScreen()).equals(Color.white)) {
			if (obj.isBasicObject()) {
				return obj;
			}
		}
		return null;
	}

	protected UML_Object getClickedObject(MouseEvent e) {
		UML_Object[] objects = canvas.getSortedObjects();
		Location point = new Location(e.getX(), e.getY());

		for (int i = objects.length - 1; i >= 0; i--) {
			UML_Object obj = objects[i];
			if (obj.isClicked(point)) {
				return obj;
			}
		}
		return null;
	}
}
