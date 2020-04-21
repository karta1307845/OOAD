package listener;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.AssociationLine;
import model.BasicObject;
import model.ClassObject;
import model.CompositionLine;
import model.ConnectionLine;
import model.GeneralizationLine;
import model.Location;
import model.Rectangle;
import model.UML_Editor;
import model.UML_Object;
import model.UseCaseObject;
import view.Canvas;

public class CanvasListener implements MouseListener, MouseMotionListener {
	private Robot robot;
	private UML_Editor editor;
	private Canvas canvas;

	private BasicObject startConnectObject;
	private Location start;
	private ConnectionLine tempLine;
	private Rectangle tempRectangle;

	public CanvasListener(UML_Editor editor, Canvas canvas) throws AWTException {
		this.canvas = canvas;
		this.editor = editor;
		robot = new Robot();

		startConnectObject = null;
		start = null;
		tempLine = null;
		tempRectangle = null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mode = editor.getMode();
		int x = e.getX();
		int y = e.getY();

		switch (mode) {
		case 0:
			BasicObject obj;
			obj = getClickedBasicObject(e);
			editor.unSelectAllObjects();
			if (obj != null) {
				editor.selectObject(obj);
			}
			break;
		case 4:
			obj = new ClassObject(new Location(x, y));
			editor.addObject(obj);
			break;
		case 5:
			obj = new UseCaseObject(new Location(x, y));
			editor.addObject(obj);
			break;
		}
		canvas.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mode = editor.getMode();
		int x = e.getX();
		int y = e.getY();
		BasicObject obj = getClickedBasicObject(e);

		switch (mode) {
		case 0:
			if (obj == null) {
				start = new Location(x, y);
			}
			break;
		case 1:
		case 2:
		case 3:
			if (obj != null) {
				startConnectObject = obj;
				start = startConnectObject.getMappingPort(new Location(x, y));
			}
			break;
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int mode = editor.getMode();
		int x = e.getX();
		int y = e.getY();
		BasicObject obj = getClickedBasicObject(e);

		switch (mode) {
		case 0:
			if (tempRectangle != null) {
				editor.unSelectAllObjects();
				BasicObject[] selectedObjects = tempRectangle.selectAllBasicObjects(editor.getSortedObject());
				for (BasicObject i : selectedObjects) {
					editor.selectObject(i);
				}
				editor.removeObject(tempRectangle);
			}
			start = null;
			tempRectangle = null;
			break;
		case 1:
			ConnectionLine line;
			if (obj != null && startConnectObject != null) {
				if (!obj.equals(startConnectObject)) {
					Location end = obj.getMappingPort(new Location(x, y));
					line = new AssociationLine(start, end);
					editor.addObject(line);
				}
			}
			break;
		case 2:
			if (obj != null && startConnectObject != null) {
				if (!obj.equals(startConnectObject)) {
					Location end = obj.getMappingPort(new Location(x, y));
					line = new GeneralizationLine(start, end);
					editor.addObject(line);
				}
			}
			break;
		case 3:
			if (obj != null && startConnectObject != null) {
				if (!obj.equals(startConnectObject)) {
					Location end = obj.getMappingPort(new Location(x, y));
					line = new CompositionLine(start, end);
					editor.addObject(line);
				}
			}
			break;
		}

		if (tempLine != null) {
			editor.removeObject(tempLine);
			tempLine = null;
		}
		startConnectObject = null;
		start = null;
		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int mode = editor.getMode();
		int x = e.getX();
		int y = e.getY();

		switch (mode) {
		case 0:
			if (tempRectangle != null) {
				editor.removeObject(tempRectangle);
			}
			if (start != null) {
				tempRectangle = new Rectangle(start, new Location(x, y));
				editor.addObject(tempRectangle);
				canvas.repaint();
			}
			break;
		case 1:
			if (tempLine != null) {
				editor.removeObject(tempLine);
			}
			if (startConnectObject != null) {
				tempLine = new AssociationLine(start, new Location(x, y));
				editor.addObject(tempLine);
				canvas.repaint();
			}
			break;
		case 2:
			if (tempLine != null) {
				editor.removeObject(tempLine);
			}
			if (startConnectObject != null) {
				tempLine = new GeneralizationLine(start, new Location(x, y));
				editor.addObject(tempLine);
				canvas.repaint();
			}
			break;
		case 3:
			if (tempLine != null) {
				editor.removeObject(tempLine);
			}
			if (startConnectObject != null) {
				tempLine = new CompositionLine(start, new Location(x, y));
				editor.addObject(tempLine);
				canvas.repaint();
			}
			break;
		}

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	private BasicObject getClickedBasicObject(MouseEvent e) {
		if (!robot.getPixelColor(e.getXOnScreen(), e.getYOnScreen()).equals(Color.white)) {
			UML_Object[] objects = editor.getSortedObject();
			Location clickPoint = new Location(e.getX(), e.getY());

			for (UML_Object i : objects) {
				if (i instanceof BasicObject) {
					if (((BasicObject) i).isClicked(clickPoint)) {
						return (BasicObject) i;
					}
				}
			}
		}

		return null;
	}

}
