package listener;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import event.DrawLineEvent;
import event.DrawRectangleEvent;
import event.Event;
import event.MoveEvent;
import model.ClassObject;
import model.Location;
import model.ShapeObject;
import model.UML_Editor;
import model.UML_Object;
import model.UseCaseObject;
import view.Canvas;

public class CanvasListener implements MouseListener, MouseMotionListener {
	private Robot robot;
	private UML_Editor editor;
	private Canvas canvas;

	private Event action1;
	private Event action2;

	public CanvasListener(UML_Editor editor, Canvas canvas) throws AWTException {
		this.canvas = canvas;
		this.editor = editor;
		robot = new Robot();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mode = editor.getMode();
		int x = e.getX();
		int y = e.getY();

		switch (mode) {
		case 0:
			ShapeObject obj;
			obj = getClickedShapeObject(e);
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

		switch (mode) {
		case 0:
			action1 = new MoveEvent(editor, robot);
			action1.press(e);

			action2 = new DrawRectangleEvent(editor, robot);
			action2.press(e);

			break;
		case 1:
		case 2:
		case 3:
			action1 = new DrawLineEvent(editor, robot, mode);
			action1.press(e);
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (action1 != null) {
			action1.release(e);
			action1 = null;
		}
		if (action2 != null) {
			action2.release(e);
			action2 = null;
		}
		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (action1 != null) {
			action1.drag(e);
		}
		if (action2 != null) {
			action2.drag(e);
		}
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	private ShapeObject getClickedShapeObject(MouseEvent e) {
		UML_Object[] objects = editor.getSortedObject();
		Location clickPoint = new Location(e.getX(), e.getY());

		for (UML_Object i : objects) {
			if (i instanceof ShapeObject) {
				if (((ShapeObject) i).isClicked(clickPoint)) {
					return (ShapeObject) i;
				}
			}
		}
		return null;
	}

}
