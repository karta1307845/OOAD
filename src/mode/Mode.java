package mode;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.BasicObject;
import model.Location;
import model.ShapeObject;
import model.UML_Editor;
import model.UML_Object;

public class Mode implements MouseListener, MouseMotionListener {
	protected UML_Editor editor;
	protected Robot robot;
	
	public Mode() {
		
	}
	
	public Mode(UML_Editor editor, Robot robot) {
		this.editor = editor;
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
